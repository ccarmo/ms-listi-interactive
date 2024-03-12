package com.dev.clibank.domain.entities;

import java.util.UUID;

public class Statement {

    private String idStatement;

    private Payment payment;

    public Statement(Payment payment) {
        this.idStatement = UUID.randomUUID().toString();
        this.payment = payment;
    }

    public String getIdStatement() {
        return idStatement;
    }

    public void setIdStatement(String idStatement) {
        this.idStatement = idStatement;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
