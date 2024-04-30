package com.dev.clibank.app.usecases;

import com.dev.clibank.app.rest.records.UserRecord;

import java.util.Optional;


public interface GetUser {

    Optional<UserRecord> getUser(String idUser);
}
