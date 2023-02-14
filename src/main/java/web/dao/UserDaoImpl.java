package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void addUser(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }

    }
    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public List<User> userList() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
    @Override
    public void cleanTable() {
        entityManager.createQuery("delete from User where id > 0").executeUpdate();
    }
    @Override
    public void updateUser(Long id, User newUser) {
        User user = entityManager.find(User.class, id);
        user.setName(newUser.getName());
        user.setAge(newUser.getAge());
        user.setLastName(newUser.getLastName());
    }
    @Override
    public void deleteUser(long id) {
        entityManager.createQuery("delete from User where id=" + id).executeUpdate();
    }
}
