package com.crowd.bean.donate;

import com.crowd.entity.Donate;

import java.sql.Timestamp;

public class UserDonatesBean {
    private int id;
    private int userId;
    private double amount;
    private String projectName;
    private Timestamp date;

    public UserDonatesBean() {
    }

    public UserDonatesBean(Donate donate) {
        this.id = donate.getId();
        this.amount = donate.getAmount();
        this.projectName = donate.getProjectId().getNameProject();
        this.date = donate.getDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
}
