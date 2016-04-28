package com.crowd.controller;

import com.crowd.bean.RegistrationFields;
import com.crowd.bean.user.UserBean;
import com.crowd.config.TestHibernateConfig;
import com.crowd.controller.api.DonateApiController;
import com.crowd.dao.DonateDAO;
import com.crowd.service.DonateService;
import com.crowd.service.ProjectService;
import com.crowd.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.transaction.Transactional;

import static com.crowd.controller.DonateApiControllerCreateProjectMethodTest.ProjectData.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestHibernateConfig.class}, loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
@Transactional
public class DonateApiControllerCreateProjectMethodTest {

    @Autowired
    private DonateApiController donateApiController;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private DonateService donateService;

    @Autowired
    private DonateDAO donateDAO;

    private int donateId;

    MockMvc mockMvc;


    @Before
    public void setUp() {
        String login = "kentback";
        userService.createAccount(new RegistrationFields(login, "kentback@example.com", "Kent", "Back", "testpwd"));
        UserBean userBean = userService.getUserByLogin(login);

        int projectId = projectService.createProject(userBean, name, needAmount, imageUrl, about, sourceUrl);
        donateService.addDonateForProject(30.0f, projectId, userBean.getId());

        donateId = donateDAO.findByDonatorAndProject(userBean.getId(), projectId).getId();

        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(donateApiController).build();
    }

    @Test
    public void When_TryApproveExistingDonate_Expect_SuccessfulResult() throws Exception {
        mockMvc.perform(
                post(String.format("/api/donates/%d/approve", donateId))
        ).andExpect(status().isOk());
    }

    @Test
    public void When_TryApproveExistingDonate_Expect_NotSuccessfulResult() throws Exception {
        mockMvc.perform(
                post(String.format("/api/donates/%d/approve", 12345))
        ).andExpect(status().isBadRequest());
    }

    static class ProjectData {
        static String name = "Stone age";
        static double needAmount = 500.0;
        static String about = "Wonderful family game with simple rules and interesting playing mechanism.";
        static String imageUrl = "http://boardgame.com.ua/components/com_virtuemart/shop_image/product/Stone_Age_51c062d4f1ae9.jpg";
        static String sourceUrl = "http://www.boardgames.com/boardgame/Treasures%20and%20Traps:%20Random%20Encounters%20expansion";
    }
}
