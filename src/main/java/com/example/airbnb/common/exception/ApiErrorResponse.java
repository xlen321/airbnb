package com.example.airbnb.common.exception;

import java.time.LocalDateTime;

public record ApiErrorResponse(
        String code,
        String message,
        LocalDateTime timestamp,
        String path) {
}
