package bean;

import crowdfunding.Project;

import java.sql.Timestamp;

public class ProjectResponse {

    private int id;

    private int userId;

    private double needAmount;

    private String aboutProject;

    private String image;

    private double donate_amount;

    private Timestamp date;

    private String status;

    private String nameProject;

    private int categoryId;

    public ProjectResponse() {
    }

    public ProjectResponse(Project project) {
        id = project.getId();
        userId = project.getUser().getId();
        needAmount = project.getNeedAmount();
        aboutProject = project.getAboutProject();
        image = project.getImage();
        donate_amount = project.getDonate_amount();
        date = project.getDate();
        status = project.getStatus();
        nameProject = project.getNameProject();
    }


    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }
}
