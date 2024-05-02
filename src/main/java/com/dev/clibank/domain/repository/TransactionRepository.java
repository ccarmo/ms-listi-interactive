package com.dev.clibank.domain.repository;

import com.dev.clibank.domain.entities.Transaction;

import java.util.List;

public interface TransactionRepository {

    void savedTransaction(Transaction transaction);

    List<Transaction> listTransaction(String accountNumber);
}
