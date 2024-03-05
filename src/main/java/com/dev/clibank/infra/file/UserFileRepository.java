package com.dev.clibank.infra.file;

import com.dev.clibank.domain.entities.User;
import com.dev.clibank.domain.repository.UserRepository;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class UserFileRepository implements UserRepository {

    @Override
    public void get(User user) {

    }
}
