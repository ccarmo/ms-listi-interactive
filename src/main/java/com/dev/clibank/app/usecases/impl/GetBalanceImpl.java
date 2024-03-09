package com.dev.clibank.app.usecases.impl;

import com.dev.clibank.app.usecases.GetBalance;
import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.domain.repository.AccountRepository;
import com.dev.clibank.exceptions.AccountNotFoundException;

import java.math.BigDecimal;
import java.util.Optional;

public class GetBalanceImpl implements GetBalance {
    private final AccountRepository accountRepository;

    public GetBalanceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public BigDecimal getBalance(String accountNumber) {
        Optional<Account> account = accountRepository.getAccountNumber(accountNumber);
        if(account.isEmpty()) {
            throw new AccountNotFoundException("Account not found for number: " + accountNumber);
        } else {
            return account.get().getBalance();
        }
    }
}
