package com.dev.clibank.domain.repository;

import com.dev.clibank.app.rest.records.RegisterUserRecord;
import com.dev.clibank.domain.entities.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> getUser(String idUser);

    Optional<User> getUsername(String email);

    Optional<User> createUser(RegisterUserRecord user);
}
