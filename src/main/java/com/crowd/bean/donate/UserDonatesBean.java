package com.crowd.bean.donate;

import com.crowd.entity.Donate;

import java.sql.Timestamp;

public class UserDonatesBean {
    private int id;
    private double donate;
    private String projectName;
    private Timestamp date;
    private String image;
    private double needAmount;
    private String author;
    private double donateAmount;
    private int projectId;

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
        this.author = donate.getProject().getUser().fullName();
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        author = author;
    }

    public double getDonate() {
        return donate;
    }

    public void setDonate(double donate) {
        this.donate = donate;
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
}
