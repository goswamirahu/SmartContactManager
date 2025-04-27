package com.SmartContactManager.dao;

import com.SmartContactManager.Entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImple implements UserDao {

    private final SessionFactory sessionFactory;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserDaoImple(SessionFactory sessionFactory, BCryptPasswordEncoder passwordEncoder) {
        this.sessionFactory = sessionFactory;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public Long saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return (Long) sessionFactory.getCurrentSession().save(user); // Spring handles the transaction
    }

    @Override
    @Transactional
    public User findByEmailAndPassword(String email, String password) {
        Query<User> query = sessionFactory.getCurrentSession()
                .createQuery("FROM User WHERE email = :email", User.class);
        query.setParameter("email", email);
        User user = query.uniqueResult();

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM User", User.class)
                .list();
    }

    @Override
    @Transactional
    public User getUserById(long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        User user = sessionFactory.getCurrentSession().get(User.class, id);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }
}
