package com.dev.clibank.app.services;

import com.dev.clibank.app.usecases.GetBalance;
import com.dev.clibank.exceptions.AccountNotFoundException;

import java.math.BigDecimal;

public class AccountService {
    private GetBalance getBalanceService;
    public  AccountService(GetBalance getBalanceService) {
        this.getBalanceService = getBalanceService;
    }

    public BigDecimal getBalance(String accountNumber) {
        try {
            return this.getBalanceService.getBalance(accountNumber);
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            return BigDecimal.ZERO;
        }
    }
}
