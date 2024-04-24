package com.dev.clibank.infra.db.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StatementModel {
    @Id
    private String idStatement;
}
