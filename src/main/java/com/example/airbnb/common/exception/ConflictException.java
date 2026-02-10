package com.example.airbnb.common.exception;

public class ConflictException extends ApplicationException {

    public ConflictException(String message) {
        super(ApiErrorCode.CONFLICT, message);
    }
    
}
