package com.dev.clibank.domain.repository;

import com.dev.clibank.domain.entities.Statement;

import java.util.List;

public interface StatementRepository {

    void savedStatement(Statement statement);
    List<Statement> getStatementAccount(String idAccount);
}
