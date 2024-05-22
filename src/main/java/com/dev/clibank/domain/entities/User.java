package com.dev.clibank.domain.entities;

import com.dev.clibank.domain.vo.Address;
import com.dev.clibank.domain.vo.Email;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {


    private String idUser;
    private String name;

    private Email email;

    private String password;



    /**
    private Address address;
     **/

    public User (String name, Email email, String password) {
        this.idUser   = UUID.randomUUID().toString();
        this.name     = name;
        this.email    = email;
        this.password = password;
    }


    public String getName() {
        return this.name;
    }
    public String getIdUser() {
        return this.idUser;
    }
    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }



    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}