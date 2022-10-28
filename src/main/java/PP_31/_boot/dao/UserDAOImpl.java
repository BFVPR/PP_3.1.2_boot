package PP_31._boot.dao;

import PP_31._boot.entity.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {


    @PersistenceContext
    private final EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> showUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User showUserById(int id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public void addUser(User user){
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int id, User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(showUserById(id));
    }
}
