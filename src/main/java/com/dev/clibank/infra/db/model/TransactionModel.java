package com.dev.clibank.infra.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class TransactionModel {

    @Id
    private String idTransaction;
    private BigDecimal value;

    private String idAccount;

    private String typeTransaction;

    private String dateTransaction;

}
