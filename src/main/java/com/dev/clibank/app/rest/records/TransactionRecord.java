package com.dev.clibank.app.rest.records;

import com.dev.clibank.domain.entities.TypeTransaction;

import java.math.BigDecimal;

public record TransactionRecord(String accountNumber, BigDecimal valueTransaction, TypeTransaction typeTransaction) {
}
