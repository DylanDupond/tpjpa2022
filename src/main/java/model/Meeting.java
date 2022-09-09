package model;


import javax.persistence.*;
import java.security.Timestamp;

@Entity
public class Meeting {
    private Long id;
    private Timestamp start;
    private Timestamp end;
    private User user;
    private Prof prof;

    public Meeting() {
    }

    @OneToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne
    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


}
