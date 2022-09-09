package Repository;

import jpa.EntityManagerHelper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import model.Meeting;

import javax.persistence.EntityManager;
import java.util.List;

public class MeetingRepository {


    public void addMeeting(Meeting meeting, EntityManager manager){
        manager.persist(meeting);
    }

    public List<Meeting> getAllMeetings (EntityManager manager){
       return manager.createQuery("Select m from Meeting m",Meeting.class).getResultList();
    }
}
