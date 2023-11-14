package com.robert.inditex.domain.exception;

public class PriceNotFoundException extends RuntimeException{

    public PriceNotFoundException(String message, Exception ex) {
        super(message);
    }
}
