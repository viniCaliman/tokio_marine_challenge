package com.tokioMarinechallenge.springboot.model.Exceptions;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
    }

    @ExceptionHandler(TransactionException.class)
    public ResponseEntity<String> handletransactionException(TransactionException ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não há taxa aplicável, não será possivel fazer a transferência");
    }
}
