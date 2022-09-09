package model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User extends Person{

    private List<Meeting> meetings;

    @OneToMany
    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }
}
