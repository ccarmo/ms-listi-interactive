package com.dev.clibank.infra.file;


import com.dev.clibank.domain.entities.User;
import org.junit.Test;

public class UserFileRepositoryTest {

    @Test
    public void saveUser() {
        User user = new User("Maria");
        UserFileRepository userFileRepository = new UserFileRepository();
        userFileRepository.save(user);


    }
}
