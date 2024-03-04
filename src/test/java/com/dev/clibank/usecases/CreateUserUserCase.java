package com.dev.clibank.usecases;

import org.junit.jupiter.api.Test;

import com.dev.clibank.domain.usecases.CreateUser;

public class CreateUserUserCase {

    @Test
    public void createUser() {
        CreateUser createUser = new CreateUser("Joao");
    }
}
