package com.dev.clibank.app.usecases.impl;

import com.dev.clibank.app.usecases.GetUser;
import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.domain.entities.User;
import com.dev.clibank.domain.repository.UserRepository;
import com.dev.clibank.exceptions.AccountNotFoundException;
import com.dev.clibank.exceptions.UserNotFoundException;

import java.util.Optional;

public class GetUserImpl implements GetUser {

    private final UserRepository userRepository;

    public GetUserImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<User> getUser(String idUser) {
        Optional<User> user = userRepository.getUser(idUser);
        if(user.isEmpty()) {
            throw new UserNotFoundException("User not found for number: " + idUser);
        } else {
            return user;
        }
    }
}
