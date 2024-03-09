package com.dev.clibank.infra.file;


import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.domain.entities.Card;
import org.junit.jupiter.api.Test;

import com.dev.clibank.domain.entities.User;

import java.math.BigDecimal;
import java.util.List;


public class UserFileRepositoryTest {

    @Test
    public void saveUser() {


        User user = new User("Carmo");
        FileJsonManager.saveFileJson(List.of(user),"user.json");
        List<User> listedUser= FileJsonManager.getFileListJson("user.json", User.class);
        for(User userPrinted: listedUser) {
            System.out.println(userPrinted.getName() + userPrinted.getId());
        }

    }
}
