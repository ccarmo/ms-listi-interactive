package com.dev.clibank.app.rest.controller;


import com.dev.clibank.app.rest.records.TransactionRecord;
import com.dev.clibank.app.services.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionRecord> createTransaction(@RequestBody TransactionRecord transactionRecord) {
        transactionService.createTransaction(transactionRecord);
        return ResponseEntity.ok(transactionRecord);
    }

    @GetMapping(produces = "text/csv")
    public ResponseEntity<?> generateCSV(@RequestParam("accountNumber") String accountNumber) {
        return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=dados.csv").body(transactionService.createCsv(accountNumber).get().toByteArray());
    }

}
