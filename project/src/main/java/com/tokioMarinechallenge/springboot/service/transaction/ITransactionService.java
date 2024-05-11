package com.tokioMarinechallenge.springboot.service.transaction;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tokioMarinechallenge.springboot.model.Transaction;

@Service
public interface ITransactionService {

    public String addTransaction(Transaction transaction) throws Exception;

    public Transaction getTransactionById(long id) throws Exception;

    public List<Transaction> getTransactions() throws Exception;

    public double calculateTax(LocalDateTime date, double value) throws Exception;
}
