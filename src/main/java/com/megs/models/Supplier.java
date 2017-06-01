package com.megs.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SUPPLIER")
public class Supplier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "NAME", nullable = false)
    String name;
    @Column(name = "PHONE_NUMBER")
    String phoneNumber;
    @Column(name = "LOCATION")
    String location;

    public Supplier() {
    }

    public Supplier(String name, String phoneNumber, String location) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.location = location;
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
}
