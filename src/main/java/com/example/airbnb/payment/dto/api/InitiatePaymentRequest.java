package com.example.airbnb.payment.dto.api;

import java.util.UUID;

import com.example.airbnb.payment.enums.PaymentMethod;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InitiatePaymentRequest {
    @NotNull(message = "Booking id is required")
    private UUID bookingId;
    
    @NotNull(message = "Payment method is required")
    private PaymentMethod paymentMethod;
}
