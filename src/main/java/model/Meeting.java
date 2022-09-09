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
