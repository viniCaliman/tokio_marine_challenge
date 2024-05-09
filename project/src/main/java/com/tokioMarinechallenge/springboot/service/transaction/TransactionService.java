package com.tokioMarinechallenge.springboot.service.transaction;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokioMarinechallenge.springboot.model.Transaction;
import com.tokioMarinechallenge.springboot.model.Exceptions.TransactionException;
import com.tokioMarinechallenge.springboot.repository.TransactionRepository;

import lombok.var;

@Service
public class TransactionService implements ITransactionService{
    
    @Autowired
    private TransactionRepository _transactionRepository;

    @Override
    public String addTransaction(Transaction transaction) throws Exception {
        try{

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

    public Transaction calculateTax(Transaction transaction) throws Exception{
        try{
            transaction.setAppointmentDate(LocalDateTime.now().withHour(0).withMinute(0).withSecond(0));
            var days = (int) ChronoUnit.DAYS.between(transaction.getAppointmentDate(), transaction.getTranferDate());

            var tax = getTax(days, transaction.getTranferValue());

            if(tax == 0.00)
                throw new TransactionException();

            transaction.setTax(tax);

        }catch(Exception ex){
            throw ex;
        }
        return transaction;
        
    }

    private double getTax(int days, double tranferValue){
        if(days == 0)
            return new BigDecimal(3.00 + ((2.5/100) * tranferValue)).setScale(2, RoundingMode.HALF_EVEN).doubleValue();

        if(days >= 1 && days <= 10)
            return 12.00;

        if(days >= 11 && days <= 20)
            return new BigDecimal((8.2/100) * tranferValue).setScale(2, RoundingMode.HALF_EVEN).doubleValue();

        if(days >= 21 && days <= 30)
            return new BigDecimal((6.9/100) * tranferValue).setScale(2, RoundingMode.HALF_EVEN).doubleValue();

        if(days >= 31 && days <= 40)
            return new BigDecimal((4.7/100) * tranferValue).setScale(2, RoundingMode.HALF_EVEN).doubleValue();

        if(days >= 41 && days <= 50)
            return new BigDecimal((1.7/100) * tranferValue).setScale(2, RoundingMode.HALF_EVEN).doubleValue();

        return 0.00;    
    }
}
