package com.example.airbnb.common.exception;

public class BusinessRuleViolationException extends ApplicationException {

    public BusinessRuleViolationException(String message) {
        super(ApiErrorCode.BUSINESS_RULE_VIOLATION, message);
    }

}
