package com.example.airbnb.common.exception;

public class NotFoundException extends ApplicationException {

    public NotFoundException(ApiErrorCode errorCode, String message) {
        super(errorCode, message);
    }

}
