package com.example.airbnb.common.exception;

public class validationException extends ApplicationException {

    public validationException(String message) {
        super(ApiErrorCode.VALIDATION_FAILED, message);
    }
    
}
