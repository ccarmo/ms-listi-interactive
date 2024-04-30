package com.dev.clibank.app.usecases;

import com.dev.clibank.app.rest.records.TransactionRecord;
import com.dev.clibank.domain.entities.Transaction;
import org.springframework.stereotype.Service;


public interface StartTransaction {

    TransactionRecord createTransaction(Transaction transaction);
}
