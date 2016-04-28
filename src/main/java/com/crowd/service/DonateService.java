package com.crowd.service;

import com.crowd.bean.donate.ApproveDonateResponse;
import com.crowd.bean.donate.DonationContributionBean;
import com.crowd.bean.donate.ProjectDonatesResponse;
import com.crowd.bean.donate.UserDonatesBean;
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

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

        Donate donate = donateDAO.findByDonatorAndProject(donatorId, projectId);

        if (Objects.isNull(donate)) {
            donate = new Donate();
            donate.setDate(new Timestamp(System.currentTimeMillis()));
            donate.setAmount(amount);
            donate.setProject(project);
            donate.setUser(donator);
        }else {
            donate.setAmount(donate.getAmount() + amount);
            donate.setDate(new Timestamp(System.currentTimeMillis()));
        }

        donateDAO.saveUpdate(donate);

        return true;
    }

    public List<UserDonatesBean> getWrapperDonates(List<Donate> donates){
        List<UserDonatesBean> userDonatesBeen = new ArrayList<>();
        for (Donate donate : donates){
            userDonatesBeen.add(new UserDonatesBean(donate));
        }
        return userDonatesBeen;
    }

    public void deleteDonateById(int id){
        donateDAO.deleteById(id);
    }

    public void saveChangeDonation(DonationContributionBean donationContributionBean){
        Donate donate = donateDAO.findById(donationContributionBean.getId());
        donate.setAmount(donationContributionBean.getDonate());
        donateDAO.saveUpdate(donate);
    }

    public ResponseEntity<ApproveDonateResponse> approveDonate(int donateId){
        Donate donate = donateDAO.findById(donateId);

        if (Objects.isNull(donate)){
            return new ResponseEntity<ApproveDonateResponse>(
                    new ApproveDonateResponse(false, String.format("Donate with id %d not found", donateId)), HttpStatus.BAD_REQUEST);
        }

        donate.setApproved(true);
        donateDAO.saveUpdate(donate);
        return new ResponseEntity<ApproveDonateResponse>(new ApproveDonateResponse(true, "Donate approved successful"), HttpStatus.OK);
    }
}
