package com.SmartContactManager.Entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cid;

    @NotNull
    private String name;

    private String secondName;
    private String work;

    @NotNull
    private String email;

    @NotNull
    private String phone;

    @Lob
    @Column(length = 5000)
    private String description;

    private String image;

    @ManyToOne(optional = true)
    @JoinColumn(name = "User_id")
    private User user;

    // Default constructor for Hibernate
    public Contact() {
    }

    // Constructor for easier object creation
    public Contact(String name, String secondName, String work, String email, String phone, String description, String image, User user) {
        this.name = name;
        this.secondName = secondName;
        this.work = work;
        this.email = email;
        this.phone = phone;
        this.description = description;
        this.image = image;
        this.user = user;
    }

    // Getters and setters
    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Override toString for better debugging
    @Override
    public String toString() {
        return "Contact{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", work='" + work + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", user=" + user +
                '}';
    }


}
