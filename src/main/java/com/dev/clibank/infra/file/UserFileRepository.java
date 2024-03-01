package com.dev.clibank.infra.file;

import com.dev.clibank.domain.entities.User;
import com.dev.clibank.domain.repository.UserRepository;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class UserFileRepository implements UserRepository {
    @Override
    public void save(User user) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("user.dat", true);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(user);
            System.out.println("Success saved user!");
        } catch (FileNotFoundException e) {
            System.out.println("Error saved user" + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error saved user" + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void get(User user) {

    }
}
