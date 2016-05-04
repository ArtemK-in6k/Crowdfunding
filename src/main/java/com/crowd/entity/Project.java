package com.crowd.entity;

import com.crowd.utils.NumberFormatter;
import org.hibernate.annotations.Type;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private double needAmount;
    @Column
    @Type(type = "text")
    private String aboutProject;
    @Column
    private String image;
    @Column
    private double donate_amount;
    @Column
    private Timestamp date;
    @Enumerated
    private Status status;
    @Column
    private String nameProject;

    @Column
    private String url;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "project")
    private List<Donate> donateList = new ArrayList<>();

    public Project() {
    }

    public Project(User user, double needAmount, String aboutProject, String image, double donate_amount, Timestamp date, Status status, String nameProject, List<Donate> donateList) {
        this.user = user;
        this.needAmount = needAmount;
        this.aboutProject = aboutProject;
        this.image = image;
        this.donate_amount = donate_amount;
        this.date = date;
        this.status = status;
        this.nameProject = nameProject;
        this.donateList = donateList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserId() {
        return user;
    }

    public void setUserId(int userId) {
        this.user = user;
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
        return donateList.stream().mapToDouble(Donate::getAmount).sum();
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public List<Donate> getDonateList() {
        return donateList;
    }

    public void setDonateList(List<Donate> donateList) {
        this.donateList = donateList;
    }

    public List<Donate> getApproveDonateList() {
        List<Donate> approvedDonates = new ArrayList<>();
        for (Donate donate : donateList) {
            if (donate.isApproved()) {
                approvedDonates.add(donate);
            }
        }
        return approvedDonates;
    }

    public double getApprovedAmount() {
        return getApproveDonateList().stream().mapToDouble(Donate::getAmount).sum();
    }

    public double percentApprovedDonate() {
        double percent = getApprovedAmount() / needAmount * 100;
        return NumberFormatter.format(percent);
    }

    public double donateSubtractApprovePercent() {
        return percendDonate() - percentApprovedDonate();
    }

    public double percendDonate() {
        double percent = getDonate_amount() / needAmount * 100;
        return NumberFormatter.format(percent);
    }

    public String dateFormat() {
        return "" + date.getDate() + "-" + (date.getMonth() + 1) + "-" + (date.getYear() + 1900);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", user=" + user +
                ", needAmount=" + needAmount +
                ", aboutProject='" + aboutProject + '\'' +
                ", image='" + image + '\'' +
                ", donate_amount=" + donate_amount +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", nameProject='" + nameProject + '\'' +
                ", donateList=" + donateList +
                '}';
    }
}
