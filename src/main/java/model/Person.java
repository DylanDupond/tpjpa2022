package model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public abstract class Person {

    private String firstName;
    private String lastName;
    private String login;
    private String mdp;

    @OneToMany
    private List<Meeting> meetings;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



}
