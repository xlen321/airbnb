package com.example.airbnb.payment.dto.internal;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.example.airbnb.payment.enums.PaymentMethod;
import com.example.airbnb.payment.enums.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentReadModel {
    private UUID paymentId;
    private UUID bookingId;
    private UUID userId;

    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private PaymentStatus status;

    private String paymentReference;
    private String providerReference;

    private LocalDateTime createdAt;
}
