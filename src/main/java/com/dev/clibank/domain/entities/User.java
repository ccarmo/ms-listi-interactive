package com.dev.clibank.domain.entities;

import com.dev.clibank.domain.vo.Address;
import com.dev.clibank.domain.vo.Email;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {


    private String idUser;
    private String name;

    /**
    private Address address;
    private Email email;
     **/

    public User (String name) {
        this.idUser   = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public String getIdUser() {
        return this.idUser;
    }


}