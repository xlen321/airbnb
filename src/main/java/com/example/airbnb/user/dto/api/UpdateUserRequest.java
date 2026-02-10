package com.example.airbnb.user.dto.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateUserRequest {
    @NotBlank
    @Size(max = 100, message = "Full name must not exceed 100 characters")
    private String fullName;

    @NotBlank
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank
    @Size(max = 12, message = "Phone number must not exceed 12 characters")
    private String phoneNumber;
}
