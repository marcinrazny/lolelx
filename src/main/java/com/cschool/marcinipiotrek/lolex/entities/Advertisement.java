package com.cschool.marcinipiotrek.lolex.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
public class Advertisement {

    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String category;
    @NotEmpty
    private double price;
    @NotEmpty
    private Date publicationDate;
    @NotEmpty
    private Date expirationDate;
    @ManyToOne
    @JoinColumn(name = "USER_EMAIL")
    private User user;

    private
    String description;

    public Advertisement(String name, String category, double price, Date publicationDate, Date expirationDate, User user) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.publicationDate = publicationDate;
        this.expirationDate = expirationDate;
        this.user = user;
    }


    public Advertisement(String name, String category, double price, Date publicationDate, Date expirationDate) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.publicationDate = publicationDate;
        this.expirationDate = expirationDate;

    }

    public Advertisement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicateDate) {
        this.publicationDate = publicateDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", publicateDate=" + publicationDate +
                ", expirationDate=" + expirationDate +
                ", user=" + user +
                ", description='" + description + '\'' +
                '}';
    }
}
