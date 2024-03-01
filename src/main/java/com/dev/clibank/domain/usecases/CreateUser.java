package com.dev.clibank.domain.usecases;

import com.dev.clibank.domain.entities.User;
import com.dev.clibank.domain.repository.UserRepository;
import com.dev.clibank.infra.file.UserFileRepository;

public class CreateUser {
    private UserRepository userRepository = new UserFileRepository();

    public CreateUser(String name) {
        createUser(name);
    }

    public void createUser(String name) {
        User user = new User(name);
        userRepository.save(user);
    }
}
