package com.app.airbnb.advice;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
  @Builder.Default
  private LocalDateTime timestamp = LocalDateTime.now();
  private T data;
  private ApiError error;
}
