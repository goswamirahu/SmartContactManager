package com.SmartContactManager.Controller;

import com.SmartContactManager.Entity.User;
import com.SmartContactManager.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public User findByEmailAndPassword(String email, String password) {
        return userService.findByEmailAndPassword(email, password);
    }

    public Long saveUser(User user) {
        return userService.saveUser(user);
    }

    public User getUserById(int id) {
        return userService.getUserById(id);
    }

    public void updateUser(User user) {
        userService.updateUser(user.getId(), user);

        // Make sure 'User' is properly imported
    }

    public void deleteUser(int id) {
        userService.deleteUser(id);
    }
}
