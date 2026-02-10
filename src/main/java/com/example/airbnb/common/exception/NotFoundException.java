package com.example.airbnb.common.exception;

public class NotFoundException extends ApplicationException {

    public NotFoundException(String message) {
        super(ApiErrorCode.NOT_FOUND, message);
    }

}
