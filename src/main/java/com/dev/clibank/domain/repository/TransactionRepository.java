package com.dev.clibank.domain.repository;

import com.dev.clibank.domain.entities.Transaction;

public interface TransactionRepository {

    void savedTransaction(Transaction transaction);
}
