package com.example.customer_service.Exception;


public class CustomerAlreadyExistsException extends RuntimeException {
    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
    
    public CustomerAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}