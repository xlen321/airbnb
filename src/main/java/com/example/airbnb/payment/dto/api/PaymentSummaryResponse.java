package com.example.airbnb.payment.dto.api;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.example.airbnb.payment.enums.PaymentStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaymentSummaryResponse {
    private UUID paymentId;
    private BigDecimal amount;
    private PaymentStatus status;
    private LocalDateTime createdAt;
}
