package com.cschool.marcinipiotrek.lolex.entities;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

public class Role {

    @Id
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;


    public Role(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public Role() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
