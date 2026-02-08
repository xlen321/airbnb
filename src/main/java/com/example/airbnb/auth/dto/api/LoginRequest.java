package com.example.airbnb.auth.dto.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {
    @NotBlank(message = "Email or phone number is required")
    private String identifier;

    @NotBlank(message = "Password or OTP is required")
    private String secret;
}
