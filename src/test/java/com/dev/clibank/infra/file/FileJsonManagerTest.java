package com.dev.clibank.infra.file;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.dev.clibank.domain.entities.User;


public class FileJsonManagerTest {
    

    @BeforeAll
    public static void saveFileJson() {

        User user = new User("Carlos");

        FileJsonManager.saveFileJson("test.json", user);
    }


    @Test
    public void getFileJsonToClass() throws FileNotFoundException {
        BufferedReader fileJsonTest = new BufferedReader(new FileReader("test.json"));
        User user = FileJsonManager.getFileJson(fileJsonTest, User.class);
        Assertions.assertEquals(user.getName(), "Carlos");
        System.out.println(user.getName());
    }


}
