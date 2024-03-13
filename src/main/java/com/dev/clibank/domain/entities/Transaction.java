package com.dev.clibank.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


public class Transaction {

    private String idTransaction;
    private BigDecimal value;

    private String idAccount;

    private String typeTransaction;

    private LocalDateTime datePayment;



    public Transaction(BigDecimal value, String idAccount, String typeTransaction, LocalDateTime datePayment) {
        this.idTransaction    = UUID.randomUUID().toString();
        this.value            = value;
        this.idAccount        = idAccount;
        this.typeTransaction  = typeTransaction;
        this.datePayment      = datePayment;

    }

    public String getIdTransaction() {
        return idTransaction;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public LocalDateTime getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(LocalDateTime datePayment) {
        this.datePayment = datePayment;
    }
}
