package com.dev.clibank.app.services;

import com.dev.clibank.app.usecases.StartTransaction;
import com.dev.clibank.domain.entities.Transaction;

public class TransactionService {

    private StartTransaction startTransactionService;

    public TransactionService(StartTransaction startTransactionService) {
        this.startTransactionService = startTransactionService;
    }

    public Transaction createTransaction(Transaction transaction) {
        this.startTransactionService.createTransaction(transaction);
        return transaction;

    }
}
