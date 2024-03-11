package com.dev.clibank.domain.entities;


import com.dev.clibank.domain.vo.Address;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Account {

    private String idUser;
    private String id;

    private String accountNumber;

    private BigDecimal balance;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(idUser, account.idUser) && Objects.equals(id, account.id) && Objects.equals(accountNumber, account.accountNumber) && Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, id, accountNumber, balance);
    }

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

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }



}