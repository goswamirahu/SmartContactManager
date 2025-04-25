package com.SmartContactManager.Sevice;
import com.SmartContactManager.Entity.User;
import com.SmartContactManager.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Long saveUser(User user){
        return userDao.saveUser(user);
    }
    @Override
    public List<User>getAllUsers(){
        return userDao.getAllUsers();
    }
    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userDao.findByEmailAndPassword(email, password);
    }

    @Override
    public User getUserById(int id){
        return userDao.getUserById(id);
    }
    @Override
    public User updateUser(int id, User user) {
        userDao.updateUser(user);
        return user;
    }
    @Override
    public void deleteUser(int id){
        userDao.deleteUser(id);
    }
}
