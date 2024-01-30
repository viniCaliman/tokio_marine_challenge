package com.tokioMarinechallenge.springboot.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokioMarinechallenge.springboot.model.Transaction;
import com.tokioMarinechallenge.springboot.repository.TransactionRepository;

@Service
public class TransactionService implements ITransactionService{

    @Autowired
    private TransactionRepository _transactionRepository;

    @Override
    public String addTransaction(Transaction transaction) throws Exception {
        try{

            //aplicar regras de negócio
            Transaction savedData = _transactionRepository.save(transaction);

            if(savedData == null)
                throw new Exception("Erro ao agendar transação");
            
            return "Transação agendada com sucesso";

        }catch(Exception ex){

            throw ex;

        }
        
    }

    @Override
    public Transaction getTransactionById(long id) {

        try{

            Transaction transaction = _transactionRepository.findById(id).get();
            if(transaction == null )
                throw new NoSuchElementException();

            return transaction;

        }catch(Exception ex){

            throw ex;

        }
        
    }

    @Override
    public  List<Transaction> getTransactions() {

        try{

            List<Transaction> list = (List<Transaction>)_transactionRepository.findAll();
            if(list.isEmpty())
                throw new NoSuchElementException();

            return list;

        }catch(Exception ex){

            throw ex;

        }
    }
}
