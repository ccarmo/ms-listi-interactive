package com.dev.clibank.app.usecases.impl;

import com.dev.clibank.app.usecases.StartTransaction;
import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.domain.entities.Transaction;
import com.dev.clibank.domain.entities.Statement;
import com.dev.clibank.domain.repository.AccountRepository;
import com.dev.clibank.domain.repository.StatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class StartTransactionImpl implements StartTransaction {

    @Autowired
    StatementRepository statementRepository;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Transaction createTransaction(Transaction transaction) {
        Optional<Account> account = accountRepository.getAccountNumber(transaction.getIdAccount());
        BigDecimal actualBalanceAccount = account.get().getBalance();
        BigDecimal newBalance = actualBalanceAccount.subtract(transaction.getValue());
        account.get().setBalance(newBalance);
        accountRepository.updatedAccount(account.get());
        Statement statement = new Statement(transaction);
        statementRepository.savedStatement(statement);
        return transaction;
    }
}
