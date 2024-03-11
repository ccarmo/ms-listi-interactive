package com.dev.clibank.app.usecases.impl;

import com.dev.clibank.app.usecases.GetStatement;
import com.dev.clibank.domain.entities.Statement;
import com.dev.clibank.domain.repository.StatementRepository;
import com.dev.clibank.infra.file.StatementFileRepository;

import java.util.List;

public class GetStatementImpl implements GetStatement {

    private StatementRepository statementRepository= new StatementFileRepository();

    public GetStatementImpl(StatementRepository statementRepository) {
        this.statementRepository = statementRepository;
    }


    @Override
    public List<Statement> getStatement(String idAccount) {
        List<Statement> listStatement = this.statementRepository.getStatementAccount(idAccount);
        return listStatement;
    }
}
