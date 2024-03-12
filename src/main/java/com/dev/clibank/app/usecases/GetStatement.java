package com.dev.clibank.app.usecases;

import com.dev.clibank.domain.entities.Statement;

import java.util.List;

public interface GetStatement {

    List<Statement> getStatement(String idAccount);
}
