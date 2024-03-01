package com.dev.clibank.infra.file;

import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.domain.repository.AccountRepository;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class AccountFileRepository implements AccountRepository {


    @Override
    public void save(Account account) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("account.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(account);
            System.out.println("Success saved account!");
        } catch (FileNotFoundException e) {
            System.out.println("Error saved account" + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error saved account" + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void get(Account account) {

    }
}
