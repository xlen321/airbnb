package com.example.airbnb.common.exception;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(ApplicationException.class)
        public ResponseEntity<ApiErrorResponse> handleApplicationException(
                        ApplicationException ex,
                        HttpServletRequest request) {
                ApiErrorResponse response = new ApiErrorResponse(
                                ex.getErrorCode().getCode(),
                                ex.getMessage(),
                                LocalDateTime.now(),
                                request.getRequestURI());

                return new ResponseEntity<>(response, ex.getErrorCode().getHttpStatus());
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ApiErrorResponse> handleValidationException(
                        MethodArgumentNotValidException ex,
                        HttpServletRequest request) {
                String message = ex.getBindingResult()
                                .getFieldErrors()
                                .stream()
                                .findFirst()
                                .map(err -> err.getDefaultMessage())
                                .orElse("Validation failed");

                ApiErrorResponse response = new ApiErrorResponse(
                                ApiErrorCode.VALIDATION_FAILED.getCode(),
                                message,
                                LocalDateTime.now(),
                                request.getRequestURI());

                return new ResponseEntity<>(response, ApiErrorCode.VALIDATION_FAILED.getHttpStatus());
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<ApiErrorResponse> handleUnexpected(Exception ex, HttpServletRequest request) {
                ApiErrorResponse response = new ApiErrorResponse(
                                ApiErrorCode.INTERNAL_ERROR.getCode(),
                                "Unexpected error occurred",
                                LocalDateTime.now(),
                                request.getRequestURI());

                return new ResponseEntity<>(response, ApiErrorCode.INTERNAL_ERROR.getHttpStatus());

        }
}
