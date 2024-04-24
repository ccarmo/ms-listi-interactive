package com.dev.clibank.app.usecases;

import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.domain.entities.User;

import java.util.Optional;

import org.springframework.stereotype.Service;


public interface GetAccount {
    Optional<Account> getAccount(String idAccount);
}
