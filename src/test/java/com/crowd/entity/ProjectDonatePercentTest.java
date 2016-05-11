package com.crowd.entity;

import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ProjectDonatePercentTest {

    private List<Donate> donateList;
    private Project project;

    @Before
    public void setUp() {
        User user = new User("Artem", "Artem", "artem@example.com", "Art", "art", "ROLE_USER" ,true);
        Donate donateFirst = new Donate(user, 100, project, false, new Timestamp(System.currentTimeMillis()));
        Donate donateSecont = new Donate(user, 200, project, true, new Timestamp(System.currentTimeMillis()));

        donateList = new ArrayList<>();
        donateList.add(donateFirst);
        donateList.add(donateSecont);

        project = new Project(user, 400, "Example", "", 0, new Timestamp(System.currentTimeMillis()),
                Status.NOT_STARTED,"Example",donateList);
    }

    @Test
    public void percentApprovedDonateTest(){
        assertThat(project.percentApprovedDonate(), is(50.0));
    }

    @Test
    public void donateSubtractApprovePercentTest(){
        assertThat(project.donateSubtractApprovePercent(), is(25.0));
    }
}
