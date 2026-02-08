package com.example.airbnb.payment.dto.api;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.example.airbnb.payment.enums.PaymentMethod;
import com.example.airbnb.payment.enums.PaymentStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaymentResponse {
    private UUID paymentId;
    private UUID bookingId;

    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private PaymentStatus status;

    private String paymentReference;

    private LocalDateTime createdAt;
}
