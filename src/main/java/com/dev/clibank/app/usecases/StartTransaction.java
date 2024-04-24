package com.dev.clibank.app.usecases;

import com.dev.clibank.domain.entities.Transaction;
import org.springframework.stereotype.Service;


public interface StartTransaction {

    Transaction createTransaction(Transaction transaction);
}
