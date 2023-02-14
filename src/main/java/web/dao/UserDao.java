package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    User getUser(Long id);
    List<User> userList ();
    void cleanTable ();
    void updateUser(Long id, User newUser );
    public void deleteUser(long id);

}
