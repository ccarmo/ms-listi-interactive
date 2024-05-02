package com.dev.clibank.app.rest.controller;

import com.dev.clibank.app.rest.records.AccountRecord;
import com.dev.clibank.app.rest.records.UserRecord;
import com.dev.clibank.app.services.AccountService;
import com.dev.clibank.app.services.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping
    public ResponseEntity<?> createAccount(@Valid @RequestBody AccountRecord account, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Erro de validação: " + bindingResult.getAllErrors());
        }
        Optional<AccountRecord> accountRecord = accountService.createAccount(account);
        return ResponseEntity.ok(accountRecord.get());
    }

    @GetMapping
    public ResponseEntity<?> getAccount(@RequestParam("accountNumber") String accountNumber) {
        if(accountNumber == null || accountNumber.isBlank() || accountNumber.isEmpty()) {
            return ResponseEntity.badRequest().body("O parâmetro 'accountNumber' é obrigatório");
        }
        Optional<AccountRecord> accountRecord = accountService.getAccount(accountNumber);
        return ResponseEntity.ok(accountRecord.get());
    }
}
