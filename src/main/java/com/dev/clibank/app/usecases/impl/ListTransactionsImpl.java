package com.dev.clibank.app.usecases.impl;

import com.dev.clibank.app.rest.records.TransactionRecord;
import com.dev.clibank.app.usecases.ListTransactions;
import com.dev.clibank.domain.entities.Transaction;
import com.dev.clibank.infra.db.mapper.TransactionMapper;
import com.dev.clibank.infra.db.model.TransactionModel;
import com.dev.clibank.infra.db.repository.TransactionRepositoryDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ListTransactionsImpl implements ListTransactions {

    @Autowired
    TransactionMapper transactionMapper;

    @Autowired
    TransactionRepositoryDb transactionRepositoryDb;

    @Override
    public List<TransactionRecord> transactionsList(String accountNumber) {
        List<Transaction> transactionlList = transactionRepositoryDb.listTransaction(accountNumber);
        List<TransactionRecord> transactionRecordList =  new ArrayList<>();
        for(Transaction transaction: transactionlList) {
            transactionRecordList.add(transactionMapper.transactionToTransactionRecord(transaction));
        }
        return transactionRecordList;
    }
}
