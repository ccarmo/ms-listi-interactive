package com.dev.clibank.app.usecases.impl;

import com.dev.clibank.app.rest.records.TransactionRecord;
import com.dev.clibank.app.usecases.StartTransaction;
import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.domain.entities.Transaction;
import com.dev.clibank.domain.entities.Statement;
import com.dev.clibank.domain.repository.AccountRepository;
import com.dev.clibank.domain.repository.StatementRepository;
import com.dev.clibank.domain.repository.TransactionRepository;
import com.dev.clibank.infra.db.mapper.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class StartTransactionImpl implements StartTransaction {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionMapper transactionMapper;

    @Override
    public TransactionRecord createTransaction(Transaction transaction) {
        Optional<Account> account = accountRepository.getAccountNumber(transaction.getIdAccount());
        BigDecimal actualBalanceAccount = account.get().getBalance();
        BigDecimal newBalance = actualBalanceAccount.subtract(transaction.getValueTransaction());
        account.get().setBalance(newBalance);
        accountRepository.updatedAccount(account.get());
        transactionRepository.savedTransaction(transaction);
        TransactionRecord transactionRecord = transactionMapper.transactionToTransactionMapper(transaction);
        return transactionRecord;
    }
}
