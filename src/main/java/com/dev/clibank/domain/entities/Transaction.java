package com.dev.clibank.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


public class Transaction {

    private String idTransaction;
    private BigDecimal valueTransaction;

    private String idAccount;

    private String typeTransaction;

    private String dateTransaction;





    public Transaction(Builder transactionBuilder) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.idTransaction    = UUID.randomUUID().toString();
        this.valueTransaction = transactionBuilder.value;
        System.out.println("Valor no builder" + valueTransaction);
        this.idAccount        = transactionBuilder.idAccount;
        this.typeTransaction  = transactionBuilder.typeTransaction;
        this.dateTransaction  = localDateTime.format(formatter);

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

    public BigDecimal getValueTransaction() {
        return valueTransaction;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public String getDateTransaction() {return this.dateTransaction;}

}
