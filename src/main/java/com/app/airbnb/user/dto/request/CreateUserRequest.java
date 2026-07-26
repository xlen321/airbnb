package com.app.airbnb.user.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
  @NotBlank(message = "First name is required")
  @Size(
    min = 2, 
    max = 50, 
    message = "First name must be between 2 and 50 characters"
  )
  private String firstName;

  @NotBlank(message = "Last name is required")
  @Size(
    min = 2, 
    max = 50, 
    message = "Last name must be between 2 and 50 characters"
  )
  private String lastName;

  @NotBlank(message = "Email is required")
  @Email(message = "Invalid email address")
  @Size(
    max = 100, 
    message = "Email cannot exceed 100 characters"
  )
  private String email;

  @NotBlank(message = "Phone number is required")
  @Pattern(
    regexp = "^\\+?[1-9]\\d{7,14}$",
    message = "Invalid phone number"
  )
  private String phone;

  @NotBlank(message = "Password is required")
  @Size(
    min = 8, 
    max = 64, 
    message = "Password must be between 8 and 64 characters"
  )
  private String password;

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
  @NotBlank(message = "Date of birth is required")
  private LocalDate dateOfBirth;
}