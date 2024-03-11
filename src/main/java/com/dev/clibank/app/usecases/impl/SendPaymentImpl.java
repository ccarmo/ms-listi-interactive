package com.dev.clibank.app.usecases.impl;

import com.dev.clibank.app.usecases.SendPayment;
import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.domain.entities.Payment;
import com.dev.clibank.domain.entities.Statement;
import com.dev.clibank.domain.repository.AccountRepository;
import com.dev.clibank.domain.repository.StatementRepository;
import com.dev.clibank.infra.file.AccountFileRepository;

import java.math.BigDecimal;
import java.util.Optional;

public class SendPaymentImpl implements SendPayment {

    private final StatementRepository statementRepository;

    public SendPaymentImpl(StatementRepository statementRepository) {
        this.statementRepository = statementRepository;
    }

    @Override
    public void sendPayment(Payment payment) {
        AccountRepository accountRepository = new AccountFileRepository();
        Optional<Account> account = accountRepository.getAccountNumber(payment.getIdAccount());
        BigDecimal actualBalanceAccount = account.get().getBalance();
        BigDecimal newBalance = actualBalanceAccount.subtract(payment.getValue());
        account.get().setBalance(newBalance);
        accountRepository.updatedAccount(account.get());
        Statement statement = new Statement(payment);
        statementRepository.savedStatement(statement);
    }
}
