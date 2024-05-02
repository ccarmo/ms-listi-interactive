package com.dev.clibank.domain;

import com.dev.clibank.domain.entities.Transaction;
import com.dev.clibank.domain.entities.TypeTransaction;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class TransationTest {

    @Test
    public void testTransactionCreation() {
        // Arrange
        BigDecimal value = new BigDecimal("100.00");
        String accountNumber = "1234567890";
        TypeTransaction type = TypeTransaction.DEPOSIT;

        // Act
        Transaction transaction = Transaction.builder()
                .value(value)
                .accountNumber(accountNumber)
                .typeTransaction(type)
                .withCreationDate()
                .build();

        System.out.println(transaction.toString());

        // Assert
        assertNotNull(transaction);
        assertNotNull(transaction.getIdTransaction());
        assertEquals(value, transaction.getValueTransaction());
        assertEquals(accountNumber, transaction.getAccountNumber());
        assertEquals(type, transaction.getTypeTransaction());
        assertNotNull(transaction.getDateTransaction());
    }

    @Test
    public void testTransactionCreationWithoutDate() {
        // Arrange
        BigDecimal value = new BigDecimal("100.00");
        String accountNumber = "1234567890";
        TypeTransaction type = TypeTransaction.DEPOSIT;

        // Act
        Transaction transaction = Transaction.builder()
                .value(value)
                .accountNumber(accountNumber)
                .typeTransaction(type)
                .build();

        System.out.println(transaction.toString());


        // Assert
        assertNotNull(transaction);
        assertNull(transaction.getIdTransaction());
        assertEquals(value, transaction.getValueTransaction());
        assertEquals(accountNumber, transaction.getAccountNumber());
        assertEquals(type, transaction.getTypeTransaction());
        assertNull(transaction.getDateTransaction());
    }

    @Test
    public void testTransactionBuilderMethods() {
        // Arrange
        BigDecimal value = new BigDecimal("100.00");
        String accountNumber = "1234567890";
        TypeTransaction type = TypeTransaction.DEPOSIT;

        // Act
        Transaction.TransactionBuilder builder = Transaction.builder();
        builder.value(value);
        builder.accountNumber(accountNumber);
        builder.typeTransaction(type);
        builder.withCreationDate();
        Transaction transaction = builder.build();

        // Assert
        assertNotNull(transaction);
        assertNotNull(transaction.getIdTransaction());
        assertEquals(value, transaction.getValueTransaction());
        assertEquals(accountNumber, transaction.getAccountNumber());
        assertEquals(type, transaction.getTypeTransaction());
        assertNotNull(transaction.getDateTransaction());
    }
}
