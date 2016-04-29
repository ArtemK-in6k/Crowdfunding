package com.crowd.controller;

import com.crowd.bean.RegistrationFields;
import com.crowd.bean.user.ChangePasswordRequest;
import com.crowd.bean.user.ChangePasswordResponse;
import com.crowd.bean.user.UserBean;
import com.crowd.config.TestHibernateConfig;
import com.crowd.controller.api.UserApiController;
import com.crowd.service.UserService;
import com.crowd.utils.Cipher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.util.Asserts;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.transaction.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestHibernateConfig.class}, loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
@Transactional
public class UserApiControllerChangePasswordMethodTest {

    private final static String CHANGE_PASSWORD_URL = "/api/users/change-password";

    @Autowired
    private UserApiController userApiController;

    @Autowired
    private UserService userService;

    private UserBean userBean;

    MockMvc mockMvc;

    @Before
    public void setup() {
        String login = "kentback";
        String password = "testpwd";
        userService.createAccount(new RegistrationFields(login, "kentback@example.com", "Kent", "Back", password));
        userBean = userService.getUserByLogin(login);

        MockitoAnnotations.initMocks(this);

        this.mockMvc = MockMvcBuilders.standaloneSetup(userApiController).build();

        userService = mock(UserService.class);

    }

    @Test
    public void When_PassNotAllRequestParams_Expect_UnsupportedMediaType() throws Exception {
        when(userService
                .changePasswordForUser(userBean.getId(),  null))
                .thenReturn(new ChangePasswordResponse(true, "Password changed successful"));

        mockMvc.perform(
                post(CHANGE_PASSWORD_URL).sessionAttr("userBean", userBean)
        ).andExpect(status().isUnsupportedMediaType());
    }

    @Test
    public void When_PassAllRequestParams_Expect_SuccessfulResponse() throws Exception {
        String currentPassword = "testpwd";
        String newPassword = "1234567";

        when(userService
                .changePasswordForUser(userBean.getId(), new ChangePasswordRequest(currentPassword, newPassword)))
                .thenReturn(new ChangePasswordResponse(true, "Password changed successful"));

        ChangePasswordRequest request = new ChangePasswordRequest(currentPassword, newPassword);

        mockMvc.perform(
                post(CHANGE_PASSWORD_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .sessionAttr("userBean", this.userBean)
                        .content(new ObjectMapper().writeValueAsString(request))
        ).andExpect(status().isOk());
    }

    @Test
    public void When_PassAllRequestParams_Expect_NotSuccessfulResponse() throws Exception {
        String currentPassword = "testpwd";
        ChangePasswordRequest request = new ChangePasswordRequest(currentPassword, "");

        when(userService
                .changePasswordForUser(userBean.getId(), new ChangePasswordRequest(currentPassword, "")))
                .thenReturn(new ChangePasswordResponse(true, "Password changed successful"));

        MvcResult result  = mockMvc.perform(
                post(CHANGE_PASSWORD_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .sessionAttr("userBean", this.userBean)
                        .content(new ObjectMapper().writeValueAsString(request))
        ).andReturn();

        ChangePasswordResponse response = new ObjectMapper().readValue(result.getResponse().getContentAsString(), ChangePasswordResponse.class);

        assertThat(response.isSuccess(), is(false));
    }
}
