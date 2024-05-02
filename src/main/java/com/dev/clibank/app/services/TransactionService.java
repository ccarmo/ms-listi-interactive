package com.dev.clibank.app.services;

import com.dev.clibank.app.rest.records.TransactionRecord;
import com.dev.clibank.app.usecases.ListTransactions;
import com.dev.clibank.app.usecases.StartTransaction;
import com.dev.clibank.app.usecases.impl.ExportCsvImpl;
import com.dev.clibank.app.usecases.impl.ListTransactionsImpl;
import com.dev.clibank.app.usecases.impl.StartTransactionImpl;
import com.dev.clibank.domain.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    StartTransactionImpl startTransactionService;

    @Autowired
    ListTransactionsImpl listTransactions;

    @Autowired
    ExportCsvImpl exportCsv;

    public TransactionRecord createTransaction(TransactionRecord transactionRecord) {

        Transaction transaction =  Transaction.builder()
                .typeTransaction(transactionRecord.typeTransaction())
                .value(transactionRecord.valueTransaction())
                .accountNumber(transactionRecord.accountNumber())
                .withCreationDate()
                .build();
        System.out.println(transactionRecord.toString());
        System.out.println(transaction.getValueTransaction());
        this.startTransactionService.createTransaction(transaction);
        return transactionRecord;

    }

    public Optional<ByteArrayOutputStream> createCsv(String accountNumber) {
        List<TransactionRecord> transactionRecordList = listTransactions.transactionsList(accountNumber);
        return exportCsv.generateCsv(transactionRecordList);

    }
}
