package com.dev.clibank.domain.entities;

import com.dev.clibank.domain.vo.Address;
import com.dev.clibank.domain.vo.Email;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {


    private String idUser;
    private String name;

    private Email email;

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    /**
    private Address address;
     **/

    public User (String name, Email email) {
        this.idUser   = UUID.randomUUID().toString();
        this.name     = name;
        this.email    = email;
    }

    public String getName() {
        return this.name;
    }
    public String getIdUser() {
        return this.idUser;
    }


}