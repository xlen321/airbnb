package com.example.airbnb.common.exception;

public class UnauthorizedException extends ApplicationException {

    public UnauthorizedException(String message) {
        super(ApiErrorCode.UNAUTHORIZED, message);
    }
    
}
