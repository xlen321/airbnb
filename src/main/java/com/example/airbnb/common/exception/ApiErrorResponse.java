package com.example.airbnb.common.exception;

public record ApiErrorResponse(ApiErrorCode code, String message) {
}
