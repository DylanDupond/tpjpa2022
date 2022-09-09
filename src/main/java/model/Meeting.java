package model;
import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@NamedQueries({
        @NamedQuery(name="Meeting.findAll",
                query="SELECT m FROM Meeting m"),
        @NamedQuery(name="Meeting.findByIdProf",
                query="SELECT m FROM Meeting m WHERE m.teacher.id = :id"),
        @NamedQuery(name="Meeting.findByIdUser",
                query="SELECT m FROM Meeting m WHERE m.user.id = :id"),
})
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Timestamp start;
    private Timestamp end;
    private String url;
    private String title;
    @OneToOne
    private User user;
    @OneToOne
    private Teacher teacher;

}
