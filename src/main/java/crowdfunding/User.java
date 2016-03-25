package crowdfunding;

import javax.persistence.*;
import java.util.List;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name",length = 45)
    private String firstName;

    @Column(name = "last_name",length = 45)
    private String lastName;

    @Column(name = "email",length = 80)
    private String email;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
    private List<Project> projects;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
    private List<Donate> donates;


    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
