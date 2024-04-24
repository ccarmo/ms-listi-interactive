package com.dev.clibank.infra.db.model;

import javax.persistence.Id;

import javax.persistence.Entity;

@Entity
public class UserModel {

    private static final String TABLE_NAME_USER = "users";

    @Id
    private String id;
    private String name;

    private String email;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
