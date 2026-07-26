package com.app.airbnb.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.airbnb.user.dto.request.CreateUserRequest;
import com.app.airbnb.user.dto.response.UserResponse;
import com.app.airbnb.user.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api/users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @PostMapping(
    value = "/create",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<UserResponse> createUser(
      @Valid @RequestBody CreateUserRequest request) {
    log.debug("[Controller] POST /create - start, email: {}, phone: {}",
        request.getEmail(), request.getPhone());

    UserResponse response = userService.createUser(request);

    log.debug("[Controller] POST /create - end, id: {}", response.getId());

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}
