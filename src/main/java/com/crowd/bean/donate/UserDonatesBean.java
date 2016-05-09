package com.crowd.bean.donate;

import com.crowd.entity.Donate;
import com.crowd.entity.Status;

import java.sql.Timestamp;

public class UserDonatesBean {
    private int id;
    private double donate;
    private String projectName;
    private Timestamp date;
    private String image;
    private double needAmount;
    private Status status;
    private double donateAmount;
    private int projectId;
    private String simpleStatus;
    private double percendDonateProject;

    public UserDonatesBean() {
    }

    public UserDonatesBean(Donate donate) {
        this.id = donate.getId();
        this.projectId = donate.getProjectId().getId();
        this.donate = donate.getAmount();
        this.projectName = donate.getProjectId().getName();
        this.date = donate.getDate();
        this.image = donate.getProject().getImage();
        this.needAmount = donate.getProject().getNeedAmount();
        this.donateAmount = donate.getProject().getDonate_amount();
        this.status = donate.getProject().getStatus();
        this.simpleStatus = status.getStatus();
        this.percendDonateProject = donate.getProject().percendDonate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getNeedAmount() {
        return needAmount;
    }

    public void setNeedAmount(double needAmount) {
        this.needAmount = needAmount;
    }

    public Status getStatus() {
        return status;
    }

    public double getDonate() {
        return donate;
    }

    public void setDonate(double donate) {
        this.donate = donate;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getSimpleStatus() {
        return simpleStatus;
    }

    public void setSimpleStatus(String simpleStatus) {
        this.simpleStatus = simpleStatus;
    }

    public double getDonateAmount() {
        return donateAmount;
    }

    public void setDonateAmount(double donateAmount) {
        this.donateAmount = donateAmount;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public double getPercendDonateProject() {
        return percendDonateProject;
    }

    public void setPercendDonateProject(double percendDonateProject) {
        this.percendDonateProject = percendDonateProject;
    }
}
