package com.example.airbnb.common.exception;

public class ForbiddenException extends ApplicationException {

    public ForbiddenException(String message) {
        super(ApiErrorCode.FORBIDDEN, message);
    }
    
}
