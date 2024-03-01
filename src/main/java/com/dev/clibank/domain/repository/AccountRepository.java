package com.dev.clibank.domain.repository;

import com.dev.clibank.domain.entities.Account;

public interface AccountRepository {

    void save(Account account);
    void get(Account account);
}
