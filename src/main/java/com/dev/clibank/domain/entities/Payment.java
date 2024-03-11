package com.dev.clibank.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;


public class Payment {

    private String id;
    private BigDecimal value;

    private String idAccount;

    private String typePayment;

    private LocalDate datePayment;



    public Payment(BigDecimal value, String idAccount, String typePayment, LocalDate datePayment) {
        this.id    = UUID.randomUUID().toString();
        this.value = value;
        this.idAccount = idAccount;
        this.typePayment = typePayment;
        this.datePayment = datePayment;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(String typePayment) {
        this.typePayment = typePayment;
    }

    public LocalDate getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(LocalDate datePayment) {
        this.datePayment = datePayment;
    }
}
