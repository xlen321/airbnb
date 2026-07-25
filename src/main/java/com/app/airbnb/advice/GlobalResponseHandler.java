package com.app.airbnb.advice;

import org.jspecify.annotations.Nullable;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {

  @Override
  public @Nullable Object beforeBodyWrite(
      @Nullable Object body,
      MethodParameter returnType,
      MediaType selectedContentType,
      Class<? extends HttpMessageConverter<?>> selectedConverterType,
      ServerHttpRequest request,
      ServerHttpResponse response) {
    String path = request.getURI().getPath();

    // Skip Swagger/OpenAPI endpoints
    if (path.startsWith("/v3/api-docs") ||
        path.startsWith("/swagger-ui") ||
        path.startsWith("/swagger-resources")) {
      return body;
    }

    // skip actuator endppoints
    if (path.startsWith("/actuator")) {
      return body;
    }

    // Only wrap JSON responses
    if (!MediaType.APPLICATION_JSON.includes(selectedContentType)) {
      return body;
    }

    // Avoid double-wrapping
    if (body == null || body instanceof ApiResponse)
      return body;

    return ApiResponse.builder()
        .data(body)
        .build();
  }

  @Override
  public boolean supports(
      MethodParameter returnType,
      Class<? extends HttpMessageConverter<?>> converterType) {
    return true;
  }

}
