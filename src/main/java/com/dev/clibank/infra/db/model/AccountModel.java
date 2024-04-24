package com.dev.clibank.infra.db.model;



import javax.persistence.Id;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class AccountModel {

    private static final String TABLE_NAME_ACCOUNT = "accounts";

    @Id
    private String idAccount;
    private String idUser;

    private String accountNumber;

    private BigDecimal balance;

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}