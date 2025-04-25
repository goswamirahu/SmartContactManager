package com.SmartContactManager.Sevice;
import com.SmartContactManager.Entity.User;
import java.util.List;
public interface UserService {
    Long saveUser(User user);
    List<User>getAllUsers();
    User getUserById(int Id);
    User updateUser(int id, User user);
    void deleteUser(int Id);
    User findByEmailAndPassword(String email, String password);

}
