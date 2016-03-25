package crowdfunding;

import javax.persistence.*;
import java.sql.Timestamp;

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
}
