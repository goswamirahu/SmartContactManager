package com.SmartContactManager.Service;

import com.SmartContactManager.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserController {

    private SessionFactory sessionFactory;

    public UserController() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }

    public User findByEmailAndPassword(String email, String password) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            // Query to find user by email and password
            User user = session.createQuery("from User where email=:email and password=:password", User.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .uniqueResult();

            session.getTransaction().commit();
            return user;

        } finally {
            session.close();
        }
    }
}
