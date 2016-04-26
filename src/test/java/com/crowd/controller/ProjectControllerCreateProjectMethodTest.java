package com.crowd.controller;

import com.crowd.bean.RegistrationFields;
import com.crowd.bean.user.UserBean;
import com.crowd.config.TestHibernateConfig;
import com.crowd.entity.Project;
import com.crowd.service.ProjectService;
import com.crowd.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.transaction.Transactional;

import static com.crowd.controller.ProjectServiceCreateProjectMethodTest.ProjectData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestHibernateConfig.class}, loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
@Transactional
public class ProjectControllerCreateProjectMethodTest {

    @Autowired
    private ProjectController projectController;

    @Autowired
    private UserService userService;

    private UserBean userBean;

    MockMvc mockMvc;

    @Before
    public void setup() {
        String login = "kenkback";
        userService.createAccount(new RegistrationFields(login, "kenkback@example.com", "Kent", "Back", "testpwd"));
        userBean = userService.getUserByLogin(login);

        MockitoAnnotations.initMocks(this);

        this.mockMvc = MockMvcBuilders.standaloneSetup(projectController).build();

    }

    @Test
    public void When_PassNotAllRequestParams_Expect_BadRequestResponse() throws Exception {
        mockMvc.perform(
                    post("/projects").sessionAttr("userBean", userBean)
                ).andExpect(status().isBadRequest());
    }

    @Test
    public void When_PassAllRequestParams_Expect_OnSuccessfulRedirect() throws Exception {
        mockMvc.perform(
                post("/projects")
                        .sessionAttr("userBean", userBean)
                        .param("projectName", ProjectData.name)
                        .param("needAmount", String.valueOf(ProjectData.needAmount))
                        .param("image", ProjectData.imageUrl)
                        .param("aboutProject", ProjectData.about)
        ).andExpect(status().isMovedTemporarily());
    }

    @Test
    public void When_PassRequestParamsWithEmptyImageUrlAndProjectDescription_Expect_OnSuccessfulRedirect() throws Exception {
        mockMvc.perform(
                post("/projects")
                        .sessionAttr("userBean", userBean)
                        .param("projectName", ProjectData.name)
                        .param("needAmount", String.valueOf(ProjectData.needAmount))
                        .param("image", "")
                        .param("aboutProject", "")
        ).andExpect(status().isMovedTemporarily());
    }

    static class ProjectData {
        static String name = "Stone age";
        static double needAmount = 500.0;
        static String about = "Wonderful family game with simple rules and interesting playing mechanism.";
        static String imageUrl = "http://boardgame.com.ua/components/com_virtuemart/shop_image/product/Stone_Age_51c062d4f1ae9.jpg";
    }
}
