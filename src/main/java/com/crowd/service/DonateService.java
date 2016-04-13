package com.crowd.service;

import com.crowd.bean.donate.DonateBean;
import com.crowd.bean.donate.ProjectDonatesResponse;
import com.crowd.dao.DonateDAO;
import com.crowd.dao.ProjectDAO;
import com.crowd.entity.Donate;
import com.crowd.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DonateService {

    @Autowired private DonateDAO donateDAO;
    @Autowired private ProjectDAO projectDAO;

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

}
