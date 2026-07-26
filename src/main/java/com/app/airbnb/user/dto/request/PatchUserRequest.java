package com.app.airbnb.user.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchUserRequest {
  @Size(
    min = 2, 
    max = 50, 
    message = "First name must be between 2 and 50 characters"
  )
  private String firstName;

  @Size(
    min = 2, 
    max = 50, 
    message = "Last name must be between 2 and 50 characters"
  )
  private String lastName;

  @Email(message = "Email should be valid")
  @Size(max = 100)
  private String email;

  @Pattern(
    regexp = "^\\+?[1-9]\\d{7,14}$", 
    message = "Phone number must be a valid phone number")
  private String phone;

  @Size(
    max = 500, 
    message = "Profile picture URL cannot exceed 500 characters"
  )
  private String profilePicture;

  @Size(
    max = 1000, 
    message = "Bio cannot exceed 1000 characters"
  )
  private String bio;

  @Past(message = "Date of birth must be in the past")
  private LocalDate dateOfBirth;
}