package com.dev.clibank.app.usecases;

import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.domain.entities.User;

import java.util.Optional;

public interface GetAccount {
    Optional<Account> getAccount(String idAccount);
}
