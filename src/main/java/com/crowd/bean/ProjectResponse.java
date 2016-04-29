package com.crowd.bean;


import com.crowd.entity.Project;
import com.crowd.utils.StringUtils;
import com.crowd.entity.Status;

import java.sql.Timestamp;
import java.util.Objects;

public class ProjectResponse {

    private int id;

    private int userId;

    private double needAmount;

    private String aboutProject;

    private String image;

    private double donate_amount;

    private String date;

    private String url;

    private Timestamp created;

    private Status status;

    private String nameProject;

    private double percendDonate;

    private String fullNameUser;

    public ProjectResponse() {
    }

    public ProjectResponse(Project project) {
        id = project.getId();
        userId = project.getUser().getId();
        needAmount = project.getNeedAmount();
        aboutProject = project.getAboutProject();
        image = project.getImage();
        donate_amount = project.getDonate_amount();
        date = project.dateFormat();
        status = project.getStatus();
        nameProject = project.getNameProject();
        percendDonate = project.percendDonate();
        fullNameUser = project.getUser().fullName();
        created = project.getDate();
        url = project.getUrl();
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

    public double getNeedAmount() {
        return needAmount;
    }

    public void setNeedAmount(double needAmount) {
        this.needAmount = needAmount;
    }

    public String getAboutProject() {
        return aboutProject;
    }

    public void setAboutProject(String aboutProject) {
        this.aboutProject = aboutProject;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getDonate_amount() {
        return donate_amount;
    }

    public void setDonate_amount(double donate_amount) {
        this.donate_amount = donate_amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPercendDonate() {
        return percendDonate;
    }

    public void setPercendDonate(double percendDonate) {
        this.percendDonate = percendDonate;
    }

    public String getFullNameUser() {
        return fullNameUser;
    }

    public void setFullNameUser(String fullNameUser) {
        this.fullNameUser = fullNameUser;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getSimpleStatus() {
        return status.getStatus();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUrlPresent() {
        return !StringUtils.isBlank(url);
    }

    public boolean isImagePresent() {
        return !StringUtils.isBlank(image);
    }

}
