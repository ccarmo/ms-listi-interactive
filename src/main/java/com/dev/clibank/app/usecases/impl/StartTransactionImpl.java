package com.dev.clibank.app.usecases.impl;

import com.dev.clibank.app.usecases.StartTransaction;
import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.domain.entities.Transaction;
import com.dev.clibank.domain.entities.Statement;
import com.dev.clibank.domain.repository.AccountRepository;
import com.dev.clibank.domain.repository.StatementRepository;
import com.dev.clibank.infra.file.AccountFileRepository;

import java.math.BigDecimal;
import java.util.Optional;

public class StartTransactionImpl implements StartTransaction {

    private final StatementRepository statementRepository;

    public StartTransactionImpl(StatementRepository statementRepository) {
        this.statementRepository = statementRepository;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        AccountRepository accountRepository = new AccountFileRepository();
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
