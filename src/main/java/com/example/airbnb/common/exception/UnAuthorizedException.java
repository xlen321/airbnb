package com.example.airbnb.common.exception;

public class UnAuthorizedException extends ApplicationException {

    public UnAuthorizedException(ApiErrorCode errorCode, String message) {
        super(errorCode, message);
    }
    
}
