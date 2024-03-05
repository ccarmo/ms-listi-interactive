package com.dev.clibank.domain.entities;

import com.dev.clibank.domain.vo.Address;
import com.dev.clibank.domain.vo.Email;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {

    private String name;
    private String id;

    /**
    private Address address;
    private Email email;
     **/

    public User (String name) {
        this.id   = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }


}