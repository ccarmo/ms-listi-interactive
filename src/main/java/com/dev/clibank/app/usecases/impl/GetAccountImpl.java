package com.dev.clibank.app.usecases.impl;

import com.dev.clibank.app.usecases.GetAccount;
import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.domain.entities.User;
import com.dev.clibank.domain.repository.AccountRepository;
import com.dev.clibank.exceptions.AccountNotFoundException;
import com.dev.clibank.exceptions.UserNotFoundException;

import java.util.Optional;

public class GetAccountImpl implements GetAccount {

    private final AccountRepository accountRepository;

    public GetAccountImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public Optional<Account> getAccount(String idAccount) {
        Optional<Account> account = accountRepository.getAccountNumber(idAccount);
        if(account.isEmpty()) {
            throw new AccountNotFoundException("Account not found for number: " + idAccount);
        } else {
            return account;
        }
    }
}
