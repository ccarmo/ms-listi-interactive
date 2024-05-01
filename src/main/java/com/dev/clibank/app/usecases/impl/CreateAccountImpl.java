package com.dev.clibank.app.usecases.impl;

import com.dev.clibank.app.rest.records.AccountRecord;
import com.dev.clibank.app.usecases.CreateAccount;
import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.domain.entities.TypeAccount;
import com.dev.clibank.domain.repository.AccountRepository;
import com.dev.clibank.infra.db.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CreateAccountImpl implements CreateAccount {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountMapper accountMapper;

    @Override
    public Optional<AccountRecord> createAccount(String idUser) {
        Account account = new Account(BigDecimal.ZERO, TypeAccount.CURRENT_ACCOUNT ,idUser);
        Optional<Account> accountCreated = accountRepository.createAccount(account);
        AccountRecord accountRecord = accountMapper.accountToAccountRecord(accountCreated.get());
        return Optional.of(accountRecord);
    }
}
