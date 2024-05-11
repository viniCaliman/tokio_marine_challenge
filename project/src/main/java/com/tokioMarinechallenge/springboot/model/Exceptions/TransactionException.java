package com.tokioMarinechallenge.springboot.model.Exceptions;

public class TransactionException extends RuntimeException{
    public TransactionException(String message) {
        super(message);
    }
    public TransactionException() {
        super();
    }
}
