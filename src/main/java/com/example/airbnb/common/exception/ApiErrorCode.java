package com.example.airbnb.common.exception;

import org.springframework.http.HttpStatus;

public enum ApiErrorCode {

    NOT_FOUND("ERR_404", HttpStatus.NOT_FOUND),
    VALIDATION_FAILED("ERR_400", HttpStatus.BAD_REQUEST),
    CONFLICT("ERR_409", HttpStatus.CONFLICT),
    UNAUTHORIZED("ERR_401", HttpStatus.UNAUTHORIZED),
    FORBIDDEN("ERR_403", HttpStatus.FORBIDDEN),
    BUSINESS_RULE_VIOLATION("ERR_422", HttpStatus.BAD_GATEWAY),
    INTERNAL_ERROR("ERR_500", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String code;
    private final HttpStatus httpStatus;

    ApiErrorCode(String code, HttpStatus httpStatus) {
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
