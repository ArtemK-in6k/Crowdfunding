package com.crowd.service;

import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import static com.github.choonchernlim.betterPreconditions.preconditions.PreconditionFactory.expect;

/**
 * Performs a POST on check token endpoint URL.
 */
//@Service
public class GoogleTokenServices extends RemoteTokenServices {
    private static Logger LOGGER = LoggerFactory.getLogger(GoogleTokenServices.class);

    private final String checkTokenEndpointUrl;
    private final AccessTokenConverter tokenConverter;
    private final RestTemplate restTemplate;
    private final String authorizationHeaderValue;

    @Autowired
    public GoogleTokenServices(@Value("${google.check.token.endpoint.url}") final String checkTokenEndpointUrl,
                               @Value("${google.client.id}") final String clientId,
                               @Value("${google.client.secret}") final String clientSecret,
                               final AccessTokenConverter tokenConverter) {
        this.checkTokenEndpointUrl = checkTokenEndpointUrl;
        this.tokenConverter = tokenConverter;
        this.authorizationHeaderValue = getAuthorizationHeaderValue(clientId, clientSecret);

        this.restTemplate = new RestTemplate();

        // if token is invalid, it will come back as BAD REQUEST
        this.restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                if (response.getStatusCode() != HttpStatus.BAD_REQUEST) {
                    super.handleError(response);
                }
            }
        });
    }

    @Override
    public OAuth2Authentication loadAuthentication(final String accessToken) throws AuthenticationException, InvalidTokenException {
        expect(accessToken, "accessToken").not().toBeBlank().check();

        LOGGER.debug("BEFORE: Access token: {}", accessToken);

        final Map<String, String> checkTokenResponseMap = postForMap(accessToken);

        final Map<String, String> standardizedResponseMap = getStandardizedResponseMap(checkTokenResponseMap);

        final OAuth2Authentication oAuth2Authentication = tokenConverter.extractAuthentication(standardizedResponseMap);

        LOGGER.debug("AFTER: oAuth2Authentication: {}", oAuth2Authentication);

        return oAuth2Authentication;
    }

    /**
     * Returns authorization header value.
     *
     * @param clientId     Client ID
     * @param clientSecret Client secret
     * @return Authorization header value
     */
    private String getAuthorizationHeaderValue(final String clientId, final String clientSecret) {
        expect(clientId, "clientId").not().toBeBlank().check();
        expect(clientSecret, "clientSecret").not().toBeBlank().check();

        final String credential = String.format("%s:%s", clientId, clientSecret);

        try {
            return "Basic " + new String(Base64.encode(credential.getBytes("UTF-8")));
        }
        catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Could not convert String");
        }
    }

    /**
     * Posts against check token endpoint URL and returns the response map.
     *
     * @param accessToken Access token
     * @return Response map if valid, otherwise throw InvalidTokenException
     */
    private Map<String, String> postForMap(final String accessToken) {
        expect(accessToken, "accessToken").not().toBeBlank().check();

        LOGGER.debug("BEFORE: accessToken: {}", accessToken);

        final String url = String.format(checkTokenEndpointUrl, accessToken);
        LOGGER.debug("BEFORE: url: {}", url);

        final MultiValueMap<String, String> formData = new LinkedMultiValueMap<String, String>();
        formData.set("token", accessToken);
        LOGGER.debug("BEFORE: formData: {}", formData);

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", authorizationHeaderValue);
        LOGGER.debug("BEFORE: headers: {}", headers);

        final ParameterizedTypeReference<Map<String, String>> map = new ParameterizedTypeReference<Map<String, String>>() {
        };

        final Map<String, String> checkTokenEndpointResponse = ImmutableMap.copyOf(
                restTemplate
                        .exchange(url,
                                  HttpMethod.POST,
                                  new HttpEntity<MultiValueMap<String, String>>(formData, headers),
                                  map)
                        .getBody());

        LOGGER.debug("AFTER: checkTokenEndpointResponse: {}", checkTokenEndpointResponse);

        if (checkTokenEndpointResponse.containsKey("error")) {
            throw new InvalidTokenException(checkTokenEndpointResponse.get("error"));
        }

        return checkTokenEndpointResponse;
    }

    /**
     * Use Spring Security constant fields defined at http://docs.spring.io/spring-security/oauth/apidocs/constant-values.html.
     *
     * @param responseMap Response map
     * @return Transformed response map
     */
    private Map<String, String> getStandardizedResponseMap(final Map<String, String> responseMap) {
        expect(responseMap, "responseMap").not().toBeNull().check();

        LOGGER.debug("BEFORE: Original map   : {}", responseMap);

        final Map<String, String> transformedResponseMap = ImmutableMap.<String, String>builder()
                .putAll(responseMap)
                .put("client_id", responseMap.get("issued_to"))
                .put("user_name", responseMap.get("email"))
                .put("aud", responseMap.get("audience"))
                .build();

        LOGGER.debug("AFTER: Transformed map : {}", transformedResponseMap);

        return transformedResponseMap;
    }
}
