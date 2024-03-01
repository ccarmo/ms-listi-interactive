package com.dev.clibank.usecases;

import com.dev.clibank.domain.usecases.CreateUser;
import org.junit.Test;

public class CreateUserUserCase {

    @Test
    public void createUser() {
        CreateUser createUser = new CreateUser("Joao");
    }
}
