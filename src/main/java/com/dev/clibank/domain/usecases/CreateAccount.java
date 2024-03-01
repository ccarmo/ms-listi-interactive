package com.dev.clibank.domain.usecases;


import com.dev.clibank.domain.repository.AccountRepository;
import com.dev.clibank.infra.file.AccountFileRepository;

public class CreateAccount {

    private AccountRepository accountRepository = new AccountFileRepository();

    public CreateAccount(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount() {

    }



}
