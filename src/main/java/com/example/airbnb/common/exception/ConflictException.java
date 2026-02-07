package com.example.airbnb.common.exception;

public class ConflictException extends ApplicationException {

    public ConflictException(ApiErrorCode errorCode, String message) {
        super(errorCode, message);
    }
    
}
