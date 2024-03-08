package com.dev.clibank.domain.entities;


import com.dev.clibank.domain.vo.Address;

import java.math.BigDecimal;
import java.util.UUID;

public class Account {

    private String idUser;
    private String id;

    private String accountNumber;

    private BigDecimal balance;

    public Account(String accountNumber, BigDecimal balance, String idUser) {
        this.id   = UUID.randomUUID().toString();
        this.idUser = idUser;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getIdUser() {
        return this.idUser;
    }
    public String getId() {
        return this.id;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }



}