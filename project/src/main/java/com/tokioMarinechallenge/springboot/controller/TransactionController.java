package com.tokioMarinechallenge.springboot.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tokioMarinechallenge.springboot.model.Transaction;
import com.tokioMarinechallenge.springboot.service.transaction.TransactionService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TransactionController {
    
    private TransactionService _transactionService;

    public TransactionController(TransactionService service){
        _transactionService = service;
    }

    @PostMapping("/transaction")
    public ResponseEntity<String> addTransaction(@RequestBody Transaction transaction) throws Exception{
        String response = _transactionService.addTransaction(transaction);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/transaction/calculate")
    public ResponseEntity<Object> calculateTax(@RequestParam("data") LocalDateTime data, @RequestParam("value") double value) throws Exception{
        double response = _transactionService.calculateTax(data, value);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/transactions/{id}")
    public ResponseEntity<Object> getTransactionById(@PathVariable("id") long id){
        Transaction response = _transactionService.getTransactionById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/transactions")
    public ResponseEntity<Object> getTransactions(){
        List<Transaction> response = _transactionService.getTransactions();
        return ResponseEntity.ok(response);
    }
}
