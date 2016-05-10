package com.crowd.service;

import com.crowd.bean.RegistrationFields;
import com.crowd.bean.user.UserBean;
import com.crowd.config.TestHibernateConfig;
import com.crowd.entity.Status;
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
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestHibernateConfig.class}, loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
@Transactional
public class ProjectServiceCreateProjectMethodTest {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    private UserBean userBean;

    @Before
    public void initUserBean() {
        String login = "kenkback";
        userService.createAccount(new RegistrationFields(login, "kenkback@example.com", "Kent", "Back", "testpwd"));
        userBean = userService.getUserByLogin(login);
    }

    @Test(expected = NullPointerException.class)
    public void When_ProjectCreateDataNull_Expect_ThrowsNullPointerException() {
        projectService.createProject(null, null, 0, null, null, null);
    }

    @Test
    public void When_ProjectCreateDataFillWithFullValidData_Except_ProjectIdGreaterThan0() {
        int projectId = projectService.createProject(userBean, name, needAmount, imageUrl, about, sourceUrl);
        assertThat("int", projectId, greaterThan(0));
    }

    @Test
    public void When_CreateProjectWithoutImage_Except_ProjectImageHasNullValue() {
        int projectId = projectService.createProject(userBean, name, needAmount, "", about, sourceUrl);
        String projectImage = projectService.findById(projectId).getImage();
        assertThat(projectImage, is(""));
    }

    @Test
    public void When_CreateProject_Except_NotEmptyProjectStatus() {

        int projectId = projectService.createProject(userBean, name, needAmount, "", about, sourceUrl);

        Status projectStatus = projectService.findById(projectId).getStatus();

        assertThat(projectStatus, is(notNullValue()));
    }

    static class ProjectData {
        static String name = "Stone age";
        static double needAmount = 500.0;
        static String about = "Wonderful family game with simple rules and interesting playing mechanism.";
        static String imageUrl = "http://boardgame.com.ua/components/com_virtuemart/shop_image/product/Stone_Age_51c062d4f1ae9.jpg";
        static String sourceUrl = "http://www.boardgames.com/boardgame/Treasures%20and%20Traps:%20Random%20Encounters%20expansion";
    }
}
