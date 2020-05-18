package com.cschool.marcinipiotrek.lolex.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String category;
    private double price;
    private Date publicateDate;
    private Date expirationDate;
    @ManyToOne
    private User user;


    public Advertisement(String name, String category, double price, Date publicateDate, Date expirationDate) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.publicateDate = publicateDate;
        this.expirationDate = expirationDate;

    }

    public Advertisement() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPublicateDate() {
        return publicateDate;
    }

    public void setPublicateDate(Date publicateDate) {
        this.publicateDate = publicateDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
