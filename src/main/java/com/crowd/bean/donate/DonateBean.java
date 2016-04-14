package com.crowd.bean.donate;

import com.crowd.entity.Donate;
import com.crowd.entity.Project;
import com.crowd.entity.User;

import javax.persistence.*;
import java.sql.Timestamp;

public class DonateBean {
    private int id;
    private int ownerId;
    private String ownerName;
    private double amount;
    private String projectName;
    private int projectId;
    private Timestamp date;

    public DonateBean(){}

    public DonateBean(Donate donate){
        setId(donate.getId());
        setOwnerId(donate.getUser().getId());
        setOwnerName(donate.getUser().fullName());
        setAmount(donate.getAmount());
        setProjectName(donate.getProject().getNameProject());
        setProjectId(donate.getProjectId().getId());
        setDate(donate.getDate());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}