package com.dev.clibank.infra.file;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.domain.entities.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.dev.clibank.domain.entities.User;


public class FileJsonManagerTest {
    

    @BeforeAll
    public static void saveFileJson() {

        User user = new User("Carlos");

        FileJsonManager.saveFileJson(List.of(user),"test.json");
    }


    @Test
    public void getFileJsonToClass() throws FileNotFoundException {
        BufferedReader fileJsonTest = new BufferedReader(new FileReader("test.json"));
        User user = FileJsonManager.getFileJson(fileJsonTest, User.class);
        Assertions.assertEquals(user.getName(), "Carlos");
        System.out.println(user.getName());
    }

    @Test
    public void getFileArrayJsonToClass() throws FileNotFoundException {
        List<Card> listedCard = FileJsonManager.getFileListJson("test.json", Card.class);
        //Assertions.assertEquals(user.get(0).getName(), "Carlos");
        for(Card cardPrinted: listedCard) {
            System.out.println(cardPrinted.accountUserName());
        }
    }

    @Test
    public void insertNewObject() throws FileNotFoundException {
        User user = new User("Joao");
        Account account = new Account(user);
        Card card = new Card(account,"432487","debit","983");
        FileJsonManager.updatedFileJson("card.json",card,Card.class);
        List<Card> listedCard = FileJsonManager.getFileListJson("card.json", Card.class);
        for(Card cardPrinted: listedCard) {
            System.out.println(cardPrinted.accountUserName());
        }
    }


}
