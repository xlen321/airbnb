package com.example.airbnb.common.exception;

public class ForbiddenException extends ApplicationException {

    public ForbiddenException(ApiErrorCode errorCode, String message) {
        super(errorCode, message);
    }
    
}
