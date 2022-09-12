package Repository;
import model.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserRepository {
    public List<User> getAllUsers(EntityManager manager){
        return manager.createNamedQuery("User.findAll", User.class).getResultList();
    }

    public void addUser(User user, EntityManager manager){
        manager.persist(user);
    }
}
