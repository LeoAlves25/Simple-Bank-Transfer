package com.simpleBankTransfer.simpleBankTransfer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simpleBankTransfer.simpleBankTransfer.DTO.TransactionDTO;
import com.simpleBankTransfer.simpleBankTransfer.entities.transaction.Transaction;
import com.simpleBankTransfer.simpleBankTransfer.services.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transaction) throws Exception{
        Transaction newTransaction = transactionService.createTransaction(transaction);

        return new ResponseEntity<>(newTransaction, HttpStatus.OK);
    }
}
