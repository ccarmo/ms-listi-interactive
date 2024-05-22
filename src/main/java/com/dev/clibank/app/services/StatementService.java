package com.dev.clibank.app.services;

import com.dev.clibank.app.usecases.GetStatement;
import com.dev.clibank.app.usecases.impl.GetStatementImpl;
import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.domain.entities.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class StatementService {

    @Autowired
    GetStatementImpl getStatement;


    public List<Statement> getListStatement(Account account) {
       List<Statement> statementList = getStatement.getStatement(account.getAccountNumber());
       return statementList;
    }

    private void printStatement(BigDecimal value, LocalDateTime localDateTime) {
        System.out.println("Valor: R$" + value + ", Data: " + localDateTime);
    }
}
