package com.dev.clibank.app.usecases;

import com.dev.clibank.app.rest.records.UserAuthRecord;

import java.util.Optional;

public interface GetUserAuth {

    Optional<UserAuthRecord> getUserAuth();
}
