package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDaoImpl;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    UserDaoImpl userDaoImpl;
    @Override
    @Transactional
    public void addUser(User user) {
        userDaoImpl.addUser(user);
    }

    @Override
    @Transactional
    public User getUser(long id) {
        return userDaoImpl.getUser(id);
    }
    @Override
    @Transactional
    public List<User> getUsers() {
        return userDaoImpl.userList();
    }
    @Override
    @Transactional
    public void cleanTable() {
        userDaoImpl.cleanTable();
    }
    @Override
    @Transactional
    public void deleteUser(long id) {
        userDaoImpl.deleteUser(id);
    }
    @Override
    @Transactional
    public void updateUser(long id, User user){
        userDaoImpl.updateUser(id,user);
    }
}