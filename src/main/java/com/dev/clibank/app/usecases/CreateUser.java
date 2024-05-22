package com.dev.clibank.app.usecases;

import com.dev.clibank.app.rest.records.RegisterUserRecord;
import com.dev.clibank.app.rest.records.UserRecord;
import com.dev.clibank.domain.entities.User;

import java.util.Optional;

public interface CreateUser {
    Optional<UserRecord> createUser(RegisterUserRecord user);
}
