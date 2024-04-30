package com.dev.clibank.infra.db.repository;

import com.dev.clibank.domain.entities.Transaction;
import com.dev.clibank.domain.repository.TransactionRepository;
import com.dev.clibank.infra.db.mapper.TransactionMapper;
import com.dev.clibank.infra.db.model.TransactionModel;
import com.dev.clibank.infra.db.repository.jpa.TransactionRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionRepositoryDb implements TransactionRepository {

    @Autowired
    TransactionMapper transactionMapper;
    @Autowired
    TransactionRepositoryJpa transactionRepositoryJpa;
    @Override
    public void savedTransaction(Transaction transaction) {
        TransactionModel transactionModel = transactionMapper.transactionToTransactionModel(transaction);
        System.out.println(transactionModel.toString());
        transactionRepositoryJpa.save(transactionModel);
    }
}
