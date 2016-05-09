package com.crowd.service;

import com.crowd.bean.RegistrationFields;
import com.crowd.bean.user.UserBean;
import com.crowd.config.TestHibernateConfig;
import com.crowd.entity.Donate;
import com.crowd.entity.Project;
import com.crowd.entity.Status;
import com.crowd.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import java.sql.Timestamp;

import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestHibernateConfig.class}, loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
@Transactional
public class DonateServiceDeleteDonatesTest {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;
    @Autowired
    private DonateService donateService;

    private Project project;
    private User user;

    @Before
    public void init() {
        String login = "Artem";
        userService.createAccount(new RegistrationFields(login, "test@example.com", "test", "test", "test"));
        user = userService.findByEmail("test@example.com");
        UserBean userBean = new UserBean(user);
        projectService.createProject(userBean, "The Ticket to Ride", 200.00, "http://img.ozgameshop.com/board_games/party_and_family/ticket_to_ride_10th_anniversary_edition_raw.jpg",
                "The Ticket to Ride Card Game is for 2-4 players ages 8 and older. It includes 96 Train cards, 6 Big Cities Bonus cards, 46 Destination Tickets and a rules booklet. Playing time is approximately 30 minutes.\n" +
                        "\n" +
                        "The Ticket to Ride Card Game is the perfect portable way to take your next train adventure!", "");
        project = projectService.findByProjectName("The Ticket to Ride");
    }

    @Test
    public void delete_Donate_When_Project_Have_Donate_More_90_Percent() {
        donateService.addDonateForProject(181.00f, project.getId(), user.getId());
        Donate donate = project.getDonateList().get(0);
        donateService.deleteDonateById(donate.getId());

        Double actualDonateAmount = project.getDonate_amount();
        Double expectDonateAmount = 181.00;
        Assert.assertThat(actualDonateAmount, is(expectDonateAmount));
    }
}
