package com.dev.clibank.app.usecases.impl;

import com.dev.clibank.app.rest.records.AccountRecord;
import com.dev.clibank.app.usecases.GetAccount;
import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.domain.entities.User;
import com.dev.clibank.domain.repository.AccountRepository;
import com.dev.clibank.exceptions.AccountNotFoundException;
import com.dev.clibank.exceptions.UserNotFoundException;
import com.dev.clibank.infra.db.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetAccountImpl implements GetAccount {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountMapper accountMapper;


    @Override
    public Optional<AccountRecord> getAccount(String idAccount) {
        Optional<Account> account = accountRepository.getAccountNumber(idAccount);

        if(account.isEmpty()) {
            throw new AccountNotFoundException("Account not found for number: " + idAccount);
        } else {
            AccountRecord accountRecord = accountMapper.accountToAccountRecord(account.get());
            return Optional.of(accountRecord);
        }
    }
}
