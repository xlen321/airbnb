package com.app.airbnb.exception;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends ApiException {

  protected ForbiddenException(String message, HttpStatus status) {
    super(message, HttpStatus.FORBIDDEN);
  }
  
}
