package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }


    @Transactional
    public User getUser(long id) {
        return userDao.getUser(id);
    }

    @Transactional
    public List<User> getUsers() {
        return userDao.userList();
    }

    @Transactional
    public void cleanTable() {
        userDao.cleanTable();
    }

    @Transactional
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }
    @Transactional
    public void updateUser(long id, User user){
        userDao.updateUser(id,user);
    }
}
