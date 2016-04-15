package com.crowd.entity;

import com.crowd.utils.NumberFormatter;
import org.hibernate.annotations.Type;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.sql.Timestamp;
import java.text.DecimalFormat;
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
    @Column @Type(type="text")
    private String aboutProject;
    @Column
    private String image;
    @Column
    private double donate_amount;
    @Column
    private Timestamp date;
    @Column
    private String status;
    @Column
    private String nameProject;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "project")
    private List<Donate> donateList;

    public Project() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public double percendDonate() {
        double percent =  getDonate_amount() / needAmount * 100;
        return NumberFormatter.format(percent);
    }

    public String dateFormat() {
        return "" + date.getDate() + "-" + (date.getMonth() + 1) + "-" + (date.getYear() + 1900);
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
                ", category=" + category +
                ", donateList=" + donateList +
                '}';
    }
}
