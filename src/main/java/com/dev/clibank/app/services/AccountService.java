package com.dev.clibank.app.services;

import com.dev.clibank.app.usecases.GetAccount;
import com.dev.clibank.app.usecases.GetBalance;
import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.exceptions.AccountNotFoundException;

import java.math.BigDecimal;
import java.util.Optional;

public class AccountService {
    private GetAccount getAccountService;
    public  AccountService(GetAccount getAccountService) {
        this.getAccountService = getAccountService;
    }

    public Optional<Account> getAccount(String accountNumber) {
        try {
            return this.getAccountService.getAccount(accountNumber);
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
