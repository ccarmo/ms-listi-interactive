package com.dev.clibank.infra.db.mapper;

import com.dev.clibank.app.rest.records.TransactionRecord;
import com.dev.clibank.domain.entities.Transaction;
import com.dev.clibank.domain.entities.TypeTransaction;
import com.dev.clibank.infra.db.model.TransactionModel;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", builder = @Builder)
public interface TransactionMapper {

    @Mapping(source = "transaction.typeTransaction", target = "typeTransaction", qualifiedByName = "mapTypeTransactionToString")
    TransactionModel transactionToTransactionModel(Transaction transaction);
    @Mapping(source = "transactionModel.typeTransaction", target = "typeTransaction", qualifiedByName = "mapStringToTypeTransaction")
    @Mapping(source = "transactionModel.valueTransaction", target = "value")
    Transaction transactionModelToTransaction(TransactionModel transactionModel);

    TransactionRecord transactionToTransactionRecord(Transaction transaction);

    @Named("mapStringToTypeTransaction")
    default TypeTransaction mapStringToTypeTransaction(String typeTransaction) {
        return TypeTransaction.of(typeTransaction);
    }

    @Named("mapTypeTransactionToString")
    default String mapTypeTransactionToString(TypeTransaction typeTransaction) {
        return typeTransaction.toString();
    }
}
