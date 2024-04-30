package com.dev.clibank.app.usecases;

import com.dev.clibank.app.rest.records.AccountRecord;

import java.util.Optional;

public interface CreateAccount {

    Optional<AccountRecord> createAccount(String idUser);
}
