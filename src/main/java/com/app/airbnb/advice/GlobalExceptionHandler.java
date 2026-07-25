package com.app.airbnb.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.airbnb.exception.ApiException;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ApiException.class)
  public ResponseEntity<ApiResponse<?>> handleApiException(
      ApiException ex,
      HttpServletRequest request) {
    return buildErrorResponse(
        ex.getStatus(),
        ex.getMessage(),
        request.getRequestURI(),
        null);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiResponse<?>> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpServletRequest request) {
    Map<String, String> validationErrors = new HashMap<>();

    for (FieldError error : ex.getBindingResult().getFieldErrors())
      validationErrors.put(
          error.getField(),
          error.getDefaultMessage());

    return buildErrorResponse(
        HttpStatus.BAD_REQUEST,
        "Validation failed",
        request.getRequestURI(),
        validationErrors);
  }

  public ResponseEntity<ApiResponse<?>> handleException(
      Exception ex,
      HttpServletRequest request) {
    log.error(
        "Unhandled exception on {}, {}",
        request.getMethod(),
        request.getRequestURI(),
        ex);

    return buildErrorResponse(
        HttpStatus.INTERNAL_SERVER_ERROR,
        "Something went wrong. Please try again later.",
        request.getRequestURI(),
        null);
  }

  private ResponseEntity<ApiResponse<?>> buildErrorResponse(
      HttpStatus status,
      String message,
      String path,
      Map<String, String> validationErrors) {

    ApiError error = ApiError.builder()
        .status(status.value())
        .error(status.getReasonPhrase())
        .message(message)
        .path(path)
        .validationErrors(validationErrors)
        .build();

    ApiResponse<?> response = ApiResponse.builder()
        .error(error)
        .build();

    return ResponseEntity
        .status(status)
        .body(response);
  }
}
