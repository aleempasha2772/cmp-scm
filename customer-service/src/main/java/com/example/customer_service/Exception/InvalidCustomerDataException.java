package com.example.customer_service.Exception;


public class InvalidCustomerDataException extends RuntimeException {
    public InvalidCustomerDataException(String message) {
        super(message);
    }
    
    public InvalidCustomerDataException(String message, Throwable cause) {
        super(message, cause);
    }
}