package com.SmartContactManager.dao;

import com.SmartContactManager.Entity.User;

import java.util.List;

public interface UserDao {
    Long saveUser(User user);
    User findByEmailAndPassword(String email, String password);
    List<User> getAllUsers();
    User getUserById(long id);
    void updateUser(User user);
    void deleteUser(long id);
}
