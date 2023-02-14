package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    User getUser(long id);
    List<User> getUsers();
    void cleanTable();
    void deleteUser(long id);
    void updateUser(long id, User user);
}
