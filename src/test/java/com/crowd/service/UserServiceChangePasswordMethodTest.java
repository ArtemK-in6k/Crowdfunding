package com.crowd.service;

import com.crowd.bean.RegistrationFields;
import com.crowd.bean.user.ChangePasswordRequest;
import com.crowd.bean.user.ChangePasswordResponse;
import com.crowd.bean.user.UserBean;
import com.crowd.config.TestHibernateConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import static com.crowd.service.ProjectServiceCreateProjectMethodTest.ProjectData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestHibernateConfig.class}, loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
@Transactional
public class UserServiceChangePasswordMethodTest {

    @Autowired
    private UserService userService;

    private UserBean userBean;

    @Before
    public void initUserBean() {
        String login = "kenkback";
        userService.createAccount(new RegistrationFields(login, "kenkback@example.com", "Kent", "Back", "testpwd"));
        userBean = userService.getUserByLogin(login);
    }

    @Test
    public void When_ChangePasswordRequestNotCorrect_Expect_NotSuccessResponse() {
        ChangePasswordRequest request = new ChangePasswordRequest("12345", "123456");
        ChangePasswordResponse response = userService.changePasswordForUser(userBean.getId(), request);
        assertThat(response.isSuccess(), is(false));
    }

    @Test
    public void When_ChangePasswordRequestIsCorrect_Expect_SuccessResponse() {
        ChangePasswordRequest request = new ChangePasswordRequest("testpwd", "123456");
        ChangePasswordResponse response = userService.changePasswordForUser(userBean.getId(), request);
        assertThat(response.isSuccess(), is(true));
    }

    @Test
    public void When_ChangePasswordRequestWithCorrectCurrentPasswordButNotCorrectNewPassword_Expect_NotSuccessResponse() {
        ChangePasswordRequest request = new ChangePasswordRequest("testpwd", "");
        ChangePasswordResponse response = userService.changePasswordForUser(userBean.getId(), request);
        assertThat(response.isSuccess(), is(false));
    }
}
