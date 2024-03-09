package com.dev.clibank.app.services;

import com.dev.clibank.app.usecases.GetUser;
import com.dev.clibank.domain.entities.User;
import com.dev.clibank.exceptions.UserNotFoundException;

import java.util.Optional;

public class UserService {
    private GetUser getUserService;

    public UserService(GetUser getUserService) {
        this.getUserService = getUserService;
    }

    public Optional<User> getUserService(String idUser) {
        try {
            return getUserService.getUser(idUser);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
