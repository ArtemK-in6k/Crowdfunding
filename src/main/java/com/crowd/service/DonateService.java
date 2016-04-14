package com.crowd.service;

import com.crowd.bean.donate.DonateBean;
import com.crowd.bean.donate.ProjectDonatesResponse;
import com.crowd.dao.DonateDAO;
import com.crowd.dao.ProjectDAO;
import com.crowd.dao.UserDAO;
import com.crowd.entity.Donate;
import com.crowd.entity.Project;
import com.crowd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DonateService {

    @Autowired private DonateDAO donateDAO;
    @Autowired private ProjectDAO projectDAO;
    @Autowired private UserDAO userDAO;

    public List<Donate> selectAll() {
        return donateDAO.selectAll();
    }

    public void insert(Donate donate){
        donateDAO.insert(donate);
    }

    public ResponseEntity<ProjectDonatesResponse> getProjectDonates(int projectId){
        Project project = projectDAO.findById(projectId);

        if (Objects.isNull(project)){
            return new ResponseEntity<ProjectDonatesResponse>(new ProjectDonatesResponse(), HttpStatus.BAD_REQUEST);
        }

        ProjectDonatesResponse response = new ProjectDonatesResponse(project);
        return new ResponseEntity<ProjectDonatesResponse>(response, HttpStatus.OK);
    }

    public boolean addDonateForProject(float amount, int projectId, int donatorId){
        Project project = projectDAO.findById(projectId);
        User donator = userDAO.findById(donatorId);
        
        if (Objects.isNull(project) || Objects.isNull(donator)){
            throw new IllegalArgumentException("Input parameters can't be null");
        }
        
        Donate donate = new Donate();
        donate.setDate(new Timestamp(System.currentTimeMillis()));
        donate.setAmount(amount);
        donate.setProject(project);
        donate.setUser(donator);

        donateDAO.insert(donate);

        return true;
    }

}
