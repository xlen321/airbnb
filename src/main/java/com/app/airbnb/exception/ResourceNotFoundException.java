package com.app.airbnb.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException {

  protected ResourceNotFoundException(String message, HttpStatus status) {
    super(message, HttpStatus.NOT_FOUND);
  }

}
