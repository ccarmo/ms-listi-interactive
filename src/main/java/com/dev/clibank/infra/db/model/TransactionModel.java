package com.dev.clibank.infra.db.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class TransactionModel {

    @Id
    private String id;
    private BigDecimal valueTransaction;

    private String idAccount;

    private String typeTransaction;

    private String dateTransaction;

}
