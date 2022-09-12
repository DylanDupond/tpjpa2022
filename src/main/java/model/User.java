package model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name="User.findAll",
                query="SELECT u FROM User u"),
})
public class User extends Person{

}
