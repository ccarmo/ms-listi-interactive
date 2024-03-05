package com.dev.clibank.domain.entities;


import com.dev.clibank.domain.vo.Address;

import java.util.UUID;

public class Account {

    private User user;
    private String id;

    public Account(User user) {
        this.id   = UUID.randomUUID().toString();
        this.user = user;
    }

    public String getUserName() {
        return this.user.getName();
    }
    public String getId() {
        return this.id;
    }



}