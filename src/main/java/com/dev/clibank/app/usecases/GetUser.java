package com.dev.clibank.app.usecases;

import com.dev.clibank.domain.entities.User;

import java.util.Optional;

public interface GetUser {

    Optional<User> getUser(String idUser);
}
