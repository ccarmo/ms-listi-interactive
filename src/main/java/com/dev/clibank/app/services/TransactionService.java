package com.dev.clibank.app.services;

import com.dev.clibank.app.rest.records.TransactionRecord;
import com.dev.clibank.app.usecases.StartTransaction;
import com.dev.clibank.app.usecases.impl.StartTransactionImpl;
import com.dev.clibank.domain.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {

    @Autowired
    StartTransactionImpl startTransactionService;

    public TransactionRecord createTransaction(TransactionRecord transactionRecord) {

        Transaction transaction =   new Transaction.Builder()
                .typeTransaction("CREDIT")
                .value(transactionRecord.valueTransaction())
                .idAccount(transactionRecord.accountNumber())
                .create();
        System.out.println(transactionRecord.toString());
        System.out.println(transaction.getValueTransaction());
        this.startTransactionService.createTransaction(transaction);
        return transactionRecord;

    }
}
