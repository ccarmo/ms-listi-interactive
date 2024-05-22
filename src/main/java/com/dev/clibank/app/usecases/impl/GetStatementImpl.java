package com.dev.clibank.app.usecases.impl;

import com.dev.clibank.app.usecases.GetStatement;
import com.dev.clibank.domain.entities.Statement;
import com.dev.clibank.domain.repository.StatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetStatementImpl implements GetStatement {

    @Autowired
    StatementRepository statementRepository;

    @Override
    public List<Statement> getStatement(String idAccount) {
        List<Statement> listStatement = this.statementRepository.getStatementAccount(idAccount);
        return listStatement;
    }
}
