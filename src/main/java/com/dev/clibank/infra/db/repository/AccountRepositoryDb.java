package com.dev.clibank.infra.db.repository;

import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.domain.repository.AccountRepository;
import com.dev.clibank.infra.db.repository.jpa.AccountRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountRepositoryDb implements AccountRepository {

    @Autowired
    AccountRepositoryJpa accountRepositoryJpa;

    @Override
    public Optional<Account> getAccountNumber(String accountNumber) {
        //return accountRepositoryJpa.findById(accountNumber);
        return null;
    }

    @Override
    public void updatedAccount(Account account) {

    }
}
