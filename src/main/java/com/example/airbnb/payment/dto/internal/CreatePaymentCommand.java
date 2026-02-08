package com.example.airbnb.payment.dto.internal;

import java.math.BigDecimal;
import java.util.UUID;

import com.example.airbnb.payment.enums.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreatePaymentCommand {
    private UUID bookingId;
    private UUID userId;

    private BigDecimal amount;
    private PaymentMethod paymentMethod;

    private String paymentReference;
}
