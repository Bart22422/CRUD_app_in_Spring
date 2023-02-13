package web.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public class UserDao {
    @PersistenceContext
    private EntityManager entityManager;
    public void addUser(User user) {
        if (user.getId()==null){
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }

    }
    public User getUser(Long id){
        return entityManager.find(User.class,id);
    }
    public List<User> userList (){
        return entityManager.createQuery("from User", User.class).getResultList();
    }
    public void cleanTable (){
        entityManager.createQuery("delete from User where id > 0").executeUpdate();
    }
    public void updateUser(Long id, User newUser ) {
        User user = entityManager.find(User.class, id);
        user.setName(newUser.getName());
        user.setAge(newUser.getAge());
        user.setLastName(newUser.getLastName());
    }
    public void deleteUser(long id){
        entityManager.createQuery("delete from User where id="+id).executeUpdate();
    }
}
