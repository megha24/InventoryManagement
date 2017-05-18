package com.megs.Models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Item")
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column
    String name;
    @Column
    String quality;
//    @Column
//    Double price;

    public Item(String name, String quality, Double price) {
        this.name = name;
        this.quality = quality;
//        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getQuality() {
        return quality;
    }

}
