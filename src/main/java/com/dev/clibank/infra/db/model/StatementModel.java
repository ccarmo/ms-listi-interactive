package com.dev.clibank.infra.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StatementModel {
    @Id
    private String idStatement;
}
