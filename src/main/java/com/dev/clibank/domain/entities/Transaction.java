package com.dev.clibank.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


public class Transaction {

    private String idTransaction;
    private BigDecimal value;

    private String idAccount;

    private String typeTransaction;

    private LocalDateTime dateTransaction;



    public Transaction(Builder transactionBuilder) {
        this.idTransaction    = UUID.randomUUID().toString();
        this.value            = transactionBuilder.value;
        this.idAccount        = transactionBuilder.idAccount;
        this.typeTransaction  = transactionBuilder.typeTransaction;
        this.dateTransaction  = LocalDateTime.now();

    }

    public static class Builder {

        private BigDecimal value;

        private String idAccount;

        private String typeTransaction;



        public Builder() {



        }

        public Builder value(BigDecimal value) {
            this.value = value;
            return this;
        }

        public Builder idAccount(String idAccount) {
            this.idAccount = idAccount;
            return this;
        }

        public Builder typeTransaction(String typeTransaction) {
            this.typeTransaction = typeTransaction;
            return this;
        }


        public Transaction create() {
            return new Transaction(this);
        }

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

    public String getDateTransaction() {return this.getDateTransaction();}

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

}
