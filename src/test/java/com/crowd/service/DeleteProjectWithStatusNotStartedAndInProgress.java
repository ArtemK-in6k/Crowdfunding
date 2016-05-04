package com.crowd.service;

import com.crowd.bean.RegistrationFields;
import com.crowd.bean.user.UserBean;
import com.crowd.config.TestHibernateConfig;
import com.crowd.entity.Project;
import com.crowd.entity.Status;
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

import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestHibernateConfig.class}, loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
@Transactional
public class DeleteProjectWithStatusNotStartedAndInProgress {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;

    private UserBean userBean;
    private Project project;


    @Before
    public void init() {
        String login = "Artem";
        userService.createAccount(new RegistrationFields(login, "Artem@example.com", "Artem", "Kanarskyi", "qwerty"));
        userBean = userService.getUserByLogin(login);
        projectService.createProject(userBean, "The Ticket to Ride", 200.00, "http://img.ozgameshop.com/board_games/party_and_family/ticket_to_ride_10th_anniversary_edition_raw.jpg",
                "The Ticket to Ride Card Game is for 2-4 players ages 8 and older. It includes 96 Train cards, 6 Big Cities Bonus cards, 46 Destination Tickets and a rules booklet. Playing time is approximately 30 minutes.\n" +
                        "\n" +
                        "The Ticket to Ride Card Game is the perfect portable way to take your next train adventure!","");
        project = projectService.findByProjectName("The Ticket to Ride");
    }

    @Test
    public void delete_With_Status_NotStarted() {
        projectService.delete(project);
        Integer actualAmountOfProjects = projectService.getAllProjects().size();
        Integer expectAmountOfProjects = 0;
        Assert.assertThat(actualAmountOfProjects, is(expectAmountOfProjects));
    }

    @Test
    public void delete_With_Status_InProgress() {
        project.setStatus(Status.IN_PROGRESS);
        projectService.update(project);
        projectService.delete(project);
        Integer actualAmountOfProjects = projectService.getAllProjects().size();
        Integer expectAmountOfProjects = 0;
        Assert.assertThat(actualAmountOfProjects, is(expectAmountOfProjects));
    }

    @Test
    public void delete_With_Status_Funded() {
        project.setStatus(Status.FUNDED);
        projectService.update(project);
        projectService.delete(project);
        Integer actualAmountOfProjects = projectService.getAllProjects().size();
        Integer expectAmountOfProjects = 1;
        Assert.assertThat(actualAmountOfProjects, is(expectAmountOfProjects));
    }

    @Test
    public void delete_With_Status_Completed() {
        project.setStatus(Status.COMPLETED);
        projectService.update(project);
        projectService.delete(project);
        Integer actualAmountOfProjects = projectService.getAllProjects().size();
        Integer expectAmountOfProjects = 1;
        Assert.assertThat(actualAmountOfProjects, is(expectAmountOfProjects));
    }
}