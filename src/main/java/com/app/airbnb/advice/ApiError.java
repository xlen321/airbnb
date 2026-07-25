package com.app.airbnb.advice;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
  private int status;
  private String error;
  private String message;
  private String path;
  private Map<String, String> validationErrors;
}
