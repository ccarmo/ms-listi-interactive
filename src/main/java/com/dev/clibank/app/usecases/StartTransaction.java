package com.dev.clibank.app.usecases;

import com.dev.clibank.domain.entities.Transaction;

public interface StartTransaction {

    Transaction createTransaction(Transaction transaction);
}
