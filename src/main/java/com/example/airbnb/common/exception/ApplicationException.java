package com.example.airbnb.common.exception;

public class ApplicationException extends RuntimeException {
    private final ApiErrorCode errorCode;

    protected ApplicationException(ApiErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ApiErrorCode getErrorCode() {
        return errorCode;
    }
}
