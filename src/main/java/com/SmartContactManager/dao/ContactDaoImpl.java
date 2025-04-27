package com.SmartContactManager.dao;

import com.SmartContactManager.Entity.Contact;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ContactDaoImpl implements ContactDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveContact(Contact contact) {
        sessionFactory.getCurrentSession().save(contact);  // Save contact to the database
    }

    @Override
    public List<Contact> getAllContacts() {
        // Fetch all contacts from the database
        return sessionFactory.getCurrentSession()
                .createQuery("from Contact", Contact.class)
                .getResultList();
    }
}
