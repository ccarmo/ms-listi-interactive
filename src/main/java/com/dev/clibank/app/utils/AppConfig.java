package com.dev.clibank.app.utils;

import com.dev.clibank.app.usecases.GetBalance;
import com.dev.clibank.app.usecases.impl.GetBalanceImpl;
import com.dev.clibank.domain.repository.AccountRepository;
import com.dev.clibank.infra.file.AccountFileRepository;

public class AppConfig {

    public GetBalance getBalanceUseCase() {
        AccountRepository accountRepository = new AccountFileRepository();
        return  new GetBalanceImpl(accountRepository);
    }
}
