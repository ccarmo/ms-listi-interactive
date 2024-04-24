package com.dev.clibank.app.usecases;

import com.dev.clibank.app.rest.dto.UserDTO;
import com.dev.clibank.domain.entities.Account;

import java.util.Optional;

public interface CreateUser {
    Optional<UserDTO> createUser(String name);
}
