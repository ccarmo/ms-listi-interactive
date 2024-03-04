package com.dev.clibank.infra.file;


import org.junit.jupiter.api.Test;

import com.dev.clibank.domain.entities.User;


public class UserFileRepositoryTest {

    @Test
    public void saveUser() {
        User user = new User("Maria");
        UserFileRepository userFileRepository = new UserFileRepository();
        userFileRepository.save(user);


    }
}
