package com.dev.clibank.infra.db.mapper;

import com.dev.clibank.app.rest.records.TransactionRecord;
import com.dev.clibank.domain.entities.Transaction;
import com.dev.clibank.infra.db.model.TransactionModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    TransactionModel transactionToTransactionModel(Transaction transaction);

    TransactionRecord transactionToTransactionMapper(Transaction transaction);
}
