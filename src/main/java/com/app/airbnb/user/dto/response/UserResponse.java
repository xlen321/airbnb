package com.app.airbnb.user.dto.response;

import java.time.LocalDate;
import java.util.Set;

import com.app.airbnb.user.model.enums.Role;
import com.app.airbnb.user.model.enums.UserStatus;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserResponse {
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private String profilePicture;
  private String bio;
  private LocalDate dateOfBirth;
  private UserStatus status;
  private Set<Role> roles;
}