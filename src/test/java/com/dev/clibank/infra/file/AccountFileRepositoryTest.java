package com.dev.clibank.infra.file;

import com.dev.clibank.domain.entities.User;
import org.junit.jupiter.api.Test;

import com.dev.clibank.domain.entities.Account;

import java.math.BigDecimal;
import java.util.List;


public class AccountFileRepositoryTest {

    @Test
    void saveAccount() {
        Account account = new Account("07105", BigDecimal.valueOf(100),"ae5e9df4-910e-4f2b-878b-bfa5fc8e1741");
        FileJsonManager.saveFileJson(List.of(account),"account.json");
        List<Account> accountList= FileJsonManager.getFileListJson("account.json", Account.class);
        for(Account accountPrinted: accountList) {
            System.out.println(accountPrinted.getIdUser());
        }

    }

}
