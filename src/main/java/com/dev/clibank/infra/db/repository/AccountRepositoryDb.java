package com.dev.clibank.infra.db.repository;

import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.domain.repository.AccountRepository;
import com.dev.clibank.infra.db.mapper.AccountMapper;
import com.dev.clibank.infra.db.model.AccountModel;
import com.dev.clibank.infra.db.repository.jpa.AccountRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountRepositoryDb implements AccountRepository {

    @Autowired
    AccountRepositoryJpa accountRepositoryJpa;

    @Autowired
    AccountMapper accountMapper;

    @Override
    public Optional<Account> getAccountNumber(String accountNumber) {
        Optional<AccountModel> accountModel = accountRepositoryJpa.findByAccountNumber(accountNumber);
        Account account = accountMapper.accountModelToAccount(accountModel.get());
        return Optional.of(account);
    }

    @Override
    public Optional<Account> updatedAccount(Account account) {
        return null;
    }

    @Override
    public Optional<Account> createAccount(Account account) {
        AccountModel accountModel = accountMapper.accountToAccountModel(account);
        AccountModel accountModelCreated = accountRepositoryJpa.save(accountModel);
        return Optional.of(accountMapper.accountModelToAccount(accountModelCreated));
    }
}
