package com.dev.clibank.app.services;

import com.dev.clibank.app.usecases.StartTransaction;
import com.dev.clibank.app.usecases.impl.StartTransactionImpl;
import com.dev.clibank.domain.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    StartTransactionImpl startTransactionService;

    public Transaction createTransaction(Transaction transaction) {
        this.startTransactionService.createTransaction(transaction);
        return transaction;

    }
}
