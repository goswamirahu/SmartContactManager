package com.SmartContactManager;

import com.SmartContactManager.Entity.Contact;
import com.SmartContactManager.config.AppConfig;
import com.SmartContactManager.dao.UserDao;
import com.SmartContactManager.Entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.SmartContactManager.dao.ContactDao;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Load Spring context configuration
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Initialize DAOs
        UserDao userDao = context.getBean(UserDao.class);
        ContactDao contactDao = context.getBean(ContactDao.class);

        // 1st user
        User user = new User();
        user.setUsername("rahulgiri");
        user.setName("Rahul Giri");
        user.setEmail("girirahul5152@gmail.com");
        user.setPassword("123456");

        // 2nd user
        User user2 = new User();
        user2.setUsername("vikas pandey");
        user2.setName("vikas");
        user2.setEmail("vikas@gmail.com");
        user2.setPassword("12345");

        // 3rd user
        User user3 = new User();
        user3.setUsername("vipul yadav");
        user3.setName("vipul");
        user3.setEmail("vipul@gmail.com");
        user3.setPassword("1234567");

        // Save users and get their IDs
        long id1 = userDao.saveUser(user);
        long id2 = userDao.saveUser(user2);
        long id3 = userDao.saveUser(user3);

        // Fetch saved users with generated IDs
        User savedUser1 = userDao.getUserById(id1);
        User savedUser2 = userDao.getUserById(id2);
        User savedUser3 = userDao.getUserById(id3);

        // 1st contact
        Contact contact = new Contact();
        contact.setName("rahul");
        contact.setEmail("rahul@gmail.com");
        contact.setPhone("7460805759");
        contact.setWork("myself");
        contact.setDescription("for myself");
        contact.setUser(savedUser1); // Link with user
        contactDao.saveContact(contact);
        System.out.println("✅ Contact saved successfully!");

        // 2nd contact
        Contact contact2 = new Contact();
        contact2.setName("vikas pandey");
        contact2.setEmail("vikas@gmail.com");
        contact2.setPhone("9696036372");
        contact2.setWork("long time friend");
        contact2.setDescription("from 10 class.");
        contact2.setUser(savedUser2);
        contactDao.saveContact(contact2);
        System.out.println("✅ Second contact saved successfully!");

        // 3rd contact
        Contact contact3 = new Contact();
        contact3.setName("vipul yadav");
        contact3.setEmail("vipul@gmail.com");
        contact3.setPhone("9005923947");
        contact3.setWork("long time friend");
        contact3.setDescription("meet varansi 11 class.");
        contact3.setUser(savedUser3); // Link with new user
        contactDao.saveContact(contact3);
        System.out.println("✅ Third contact for new user saved successfully!");

        // Fetch all contacts and print them out
        List<Contact> contacts = contactDao.getAllContacts();
        System.out.println("\n✅ All Saved Contacts:");
        for (Contact c : contacts) {
            System.out.println("Contact Name: " + c.getName() + ", Email: " + c.getEmail() + ", Phone: " + c.getPhone());
        }

        // Close the context
        context.close();
    }
}

