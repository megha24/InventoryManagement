package com.megs.models;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ITEM")
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "NAME", nullable = false)
    String name;
    @Column(name = "QUALITY", nullable = false)
    String quality;
    @Column(name = "PRICE", nullable = false)
    BigDecimal price;

    public Item(){

    }

    public Item(String name, String quality, BigDecimal price) {
        this.name = name;
        this.quality = quality;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getQuality() {
        return quality;
    }

   public BigDecimal getPrice(){
       return price;
   }

    public int getId(){
        return id;
    }

}
