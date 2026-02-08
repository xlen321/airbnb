package com.example.airbnb.booking.dto.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CancelBookingRequest {
    @NotBlank(message = "Reason is required")
    private String reason;
}
