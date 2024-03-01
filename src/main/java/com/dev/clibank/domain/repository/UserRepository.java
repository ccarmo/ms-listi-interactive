package com.dev.clibank.domain.repository;

import com.dev.clibank.domain.entities.User;

public interface UserRepository {
    void save(User user);
    void get(User user);
}
