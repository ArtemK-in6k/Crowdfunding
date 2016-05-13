package com.crowd.config;


import com.crowd.config.filter.AuthenticationSuccessFilter;
import com.crowd.service.GoogleTokenServices;
import com.crowd.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvcSecurity
//@ImportResource(value = "")
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailServiceImpl userDetailService;
//    @Autowired
//    private GoogleTokenServices googleTokenServices;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/**").authenticated()
                .and();

        http.addFilter();

//        <security:custom-filter ref="logoutFilter" position="LOGOUT_FILTER"/>
//        <security:custom-filter ref="oauth2ClientContextFilter" after="EXCEPTION_TRANSLATION_FILTER"/>
//        <security:custom-filter ref="oAuth2AuthenticationProcessingFilter" before="FILTER_SECURITY_INTERCEPTOR"/>
//        http.formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/j_spring_security_check")
//                .successHandler(getAuthenticationSuccess())
//                .failureUrl("/login?error=accessDenied")
//                .usernameParameter("j_username")
//                .passwordParameter("j_password")
//                .permitAll()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/**").authenticated()
//                .anyRequest().authenticated()
//                .and()
//               .logout()
//                .logoutSuccessUrl("/login")
//                .logoutUrl("/logout")
//               .permitAll();
//       http.headers().xssProtection();
    }


    @Bean
    public ShaPasswordEncoder getShaPasswordEncoder() {
        return new ShaPasswordEncoder(256);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Bean
    public DaoAuthenticationProvider getDaoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailService);
        provider.setPasswordEncoder(getShaPasswordEncoder());

        return provider;
    }

    @Bean
    public ProviderManager getProviderManager() {
        List<AuthenticationProvider> providers = new ArrayList<AuthenticationProvider>();
        providers.add(getDaoAuthenticationProvider());
        return new ProviderManager(providers);
    }

    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler getAuthenticationSuccess() {
        AuthenticationSuccessFilter authenticationSuccess = new AuthenticationSuccessFilter();
        return authenticationSuccess;
    }

//        @Bean
//    public OAuth2ClientAuthenticationProcessingFilter oAuth2AuthenticationProcessingFilter() {
//        OAuth2ClientAuthenticationProcessingFilter oAuth2ClientAuthenticationProcessingFilter
//                = new OAuth2ClientAuthenticationProcessingFilter("http://localhost:8080/login");
//        oAuth2ClientAuthenticationProcessingFilter.setRestTemplate(new OAuth2SecurityConfig().oauth2RestTemplate());
//        oAuth2ClientAuthenticationProcessingFilter.setTokenServices(googleTokenServices);
//        return oAuth2ClientAuthenticationProcessingFilter;
//    }

//    @Bean
//    public LoginUrlAuthenticationEntryPoint clientAuthenticationEntryPoint(){
//        LoginUrlAuthenticationEntryPoint loginUrlAuthenticationEntryPoint = new LoginUrlAuthenticationEntryPoint("http://localhost:8080/login");
//        return loginUrlAuthenticationEntryPoint;
//    }

//    @Bean
//    @Resource(name = "securityContextLogoutHandler")
//    public LogoutFilter logoutFilter(List<SecurityContextLogoutHandler> list) {
//        LogoutFilter logoutFilter = new LogoutFilter(,list);
//        return logoutFilter;
//    }

//    <bean id="logoutFilter" class="org.springframework.security.web.authentication.logout.LogoutFilter">
//    <constructor-arg name="logoutSuccessUrl" value="/"/>
//    <constructor-arg name="handlers">
//    <list>
//    <bean class="org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler"/>
//    </list>
//    </constructor-arg>
//    </bean>

//    @Bean
//    public List<SecurityContextLogoutHandler> securityContextLogoutHandler(){
//        List<SecurityContextLogoutHandler> list = new ArrayList<>();
//        list.add(new SecurityContextLogoutHandler());
//        return list;
//    }
}
