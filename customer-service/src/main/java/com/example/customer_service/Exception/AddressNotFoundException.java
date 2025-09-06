package com.example.customer_service.Exception;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException(String message) {
        super(message);
    }
    
    public AddressNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}