package com.dev.clibank.app.usecases.impl;

import com.dev.clibank.app.rest.records.AccountRecord;
import com.dev.clibank.app.usecases.CreateAccount;
import com.dev.clibank.app.usecases.GetUserAuth;
import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.domain.entities.TypeAccount;
import com.dev.clibank.domain.repository.AccountRepository;
import com.dev.clibank.domain.vo.Email;
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

    @Autowired
    GetUserAuthImpl getUserAuthenticated;

    @Override
    public Optional<AccountRecord> createAccount(AccountRecord accountRecord) {
        String email = getUserAuthenticated.getUserAuth().get().email();
        Account account = new Account(accountRecord.typeAccount(),email);
        Optional<Account> accountCreated = accountRepository.createAccount(account);
        AccountRecord accountRecordMapper = accountMapper.accountToAccountRecord(accountCreated.get());
        return Optional.of(accountRecordMapper);
    }
}
