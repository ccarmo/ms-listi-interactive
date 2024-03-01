package com.dev.clibank.domain.entities;

import com.dev.clibank.domain.vo.Address;
import com.dev.clibank.domain.vo.Email;

import java.io.Serializable;

public class User implements Serializable {

    private String name;

    /**
    private Address address;
    private Email email;
     **/

    public User (String name) {
        this.name = name;
    }


}