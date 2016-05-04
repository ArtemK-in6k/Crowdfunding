package com.crowd.service;

import com.crowd.bean.RegistrationFields;
import com.crowd.bean.donate.ApproveDonateResponse;
import com.crowd.bean.user.UserBean;
import com.crowd.config.TestHibernateConfig;
import com.crowd.dao.DonateDAO;
import com.crowd.entity.Donate;
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
public class DonateServiceApproveDonateMethodTest {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private DonateService donateService;

    @Autowired
    private DonateDAO donateDAO;

    private UserBean userBean;

    private int createdProjectId;

    @Before
    public void setUp() {
        String login = "kenkback";
        userService.createAccount(new RegistrationFields(login, "kenkback@example.com", "Kent", "Back", "testpwd"));
        userBean = userService.getUserByLogin(login);
        createdProjectId = projectService.createProject(userBean, name, needAmount, imageUrl, about, sourceUrl);
    }


    @Test
    public void When_ApproveDonate_Except_PositiveResponse() {

        donateService.addDonateForProject(15.0f, createdProjectId, userBean.getId());

        Integer donateId = donateDAO.findByDonatorAndProject(userBean.getId(), createdProjectId).getId();
        assertThat(donateId, is(notNullValue()));

        ApproveDonateResponse response = donateService.approveDonate(donateId).getBody();
        assertThat(response.isSuccess(), is(true));
    }

    @Test
    public void When_ApproveNotExistingDonate_Except_Exception() {
        ApproveDonateResponse response = donateService.approveDonate(510).getBody();
        assertThat(response.isSuccess(), is(false));
    }

    static class ProjectData {
        static String name = "Stone age";
        static double needAmount = 500.0;
        static String about = "Wonderful family game with simple rules and interesting playing mechanism.";
        static String imageUrl = "http://boardgame.com.ua/components/com_virtuemart/shop_image/product/Stone_Age_51c062d4f1ae9.jpg";
        static String sourceUrl = "http://www.boardgames.com/boardgame/Treasures%20and%20Traps:%20Random%20Encounters%20expansion";
    }
}
