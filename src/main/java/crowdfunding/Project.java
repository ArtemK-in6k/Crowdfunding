package crowdfunding;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Entity(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;
    @Column
    private double needAmount;
    @Column
    private String aboutProject;
    @Column
    private byte[] image;
    @Column
    private double donate_amount;
    @Column
    private Timestamp date;
    @Column
    private String status;
    @Column
    private String nameProject;

    @ManyToOne
    private Category category;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "project")
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
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
}
