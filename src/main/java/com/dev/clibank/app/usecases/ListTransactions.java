package com.dev.clibank.app.usecases;

import com.dev.clibank.app.rest.records.AccountRecord;
import com.dev.clibank.app.rest.records.TransactionRecord;

import java.util.List;

public interface ListTransactions {

    List<TransactionRecord> transactionsList(String accountNumber);
}
