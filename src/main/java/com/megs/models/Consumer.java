package com.megs.models;

import javax.persistence.*;

@Entity
@Table(name = "CONSUMER")
public class Consumer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "NAME", nullable = false)
    String name;
    @Column(name = "PHONE_NUMBER")
    String phoneNumber;
    @Column(name = "LOCATION")
    String location;
    @Column(name = "EMAIL_ID")
    String emailId;

    public Consumer() {
    }

    public Consumer(String name, String phoneNumber, String location, String emailId) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.emailId = emailId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public String getEmailId() {
        return emailId;
    }
}
