package com.dev.clibank.app.usecases;

import com.dev.clibank.app.rest.records.TransactionRecord;
import com.dev.clibank.domain.entities.Transaction;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;

public interface ExportCsv {

    Optional<ByteArrayOutputStream> generateCsv(List<TransactionRecord> transactionList);
}
