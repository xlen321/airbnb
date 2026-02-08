package com.example.airbnb.guest.dto.api;

import com.example.airbnb.guest.enums.GuestGender;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddGuestRequest {
    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotNull(message = "Gender is required")
    private GuestGender gender;

    @NotNull(message = "Age is required")
    private Integer age;
}
