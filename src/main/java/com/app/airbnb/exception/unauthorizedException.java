package com.app.airbnb.exception;

import org.springframework.http.HttpStatus;

public class unauthorizedException extends ApiException {

  protected unauthorizedException(String message, HttpStatus status) {
    super(message, HttpStatus.UNAUTHORIZED);
  }
  
}
