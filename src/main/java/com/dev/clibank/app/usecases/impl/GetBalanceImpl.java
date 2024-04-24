package com.dev.clibank.app.usecases.impl;

import com.dev.clibank.app.usecases.GetBalance;
import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.domain.repository.AccountRepository;
import com.dev.clibank.exceptions.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class GetBalanceImpl implements GetBalance {

    @Autowired
    AccountRepository accountRepository;

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
