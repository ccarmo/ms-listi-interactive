package com.dev.clibank.infra.db.model;


import com.dev.clibank.domain.entities.TypeTransaction;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class TransactionModel {

    private static final String TABLE_NAME_TRANSACTIONS = "transactions";
    @Id
    private String idTransaction;
    private BigDecimal valueTransaction;

    private String idAccount;

    private TypeTransaction typeTransaction;

    private String dateTransaction;

    public String getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }

    public BigDecimal getValueTransaction() {
        return valueTransaction;
    }

    public void setValueTransaction(BigDecimal valueTransaction) {
        this.valueTransaction = valueTransaction;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public TypeTransaction getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(TypeTransaction typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public String getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(String dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    @Override
    public String toString() {
        return "TransactionModel{" +
                "idTransaction='" + idTransaction + '\'' +
                ", valueTransaction=" + valueTransaction +
                ", idAccount='" + idAccount + '\'' +
                ", typeTransaction='" + typeTransaction + '\'' +
                ", dateTransaction='" + dateTransaction + '\'' +
                '}';
    }
}
