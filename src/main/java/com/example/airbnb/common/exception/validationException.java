package com.example.airbnb.common.exception;

public class validationException extends ApplicationException {

    public validationException(ApiErrorCode errorCode, String message) {
        super(errorCode, message);
    }
    
}
