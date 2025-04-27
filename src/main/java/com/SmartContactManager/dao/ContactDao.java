package com.SmartContactManager.dao;

import com.SmartContactManager.Entity.Contact;
import java.util.List;

public interface ContactDao {
    void saveContact(Contact contact);
    List<Contact> getAllContacts();  // Method to fetch all contacts
}

