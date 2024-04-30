package com.dev.clibank.app.services;

import com.dev.clibank.app.rest.records.AccountRecord;
import com.dev.clibank.app.usecases.GetAccount;
import com.dev.clibank.app.usecases.GetBalance;
import com.dev.clibank.app.usecases.impl.CreateAccountImpl;
import com.dev.clibank.app.usecases.impl.GetAccountImpl;
import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.exceptions.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    GetAccountImpl getAccountService;

    @Autowired
    CreateAccountImpl createAccountService;

    public Optional<AccountRecord> getAccount(String accountNumber) {
        try {
            return this.getAccountService.getAccount(accountNumber);
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public Optional<AccountRecord> createAccount(String idUser) {
        Optional<AccountRecord> accountRecord = createAccountService.createAccount(idUser);
        return accountRecord;
    }
}
