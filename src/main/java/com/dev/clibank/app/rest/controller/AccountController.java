package com.dev.clibank.app.rest.controller;

import com.dev.clibank.app.rest.records.AccountRecord;
import com.dev.clibank.app.rest.records.UserRecord;
import com.dev.clibank.app.services.AccountService;
import com.dev.clibank.app.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountRecord> createUser(@RequestParam("idUser") String idUser) {
        Optional<AccountRecord> accountRecord = accountService.createAccount(idUser);
        return ResponseEntity.ok(accountRecord.get());
    }

    @GetMapping
    public ResponseEntity<AccountRecord> getUser(@RequestParam("accountNumber") String accountNumber) {
        Optional<AccountRecord> accountRecord = accountService.getAccount(accountNumber);
        return ResponseEntity.ok(accountRecord.get());
    }
}
