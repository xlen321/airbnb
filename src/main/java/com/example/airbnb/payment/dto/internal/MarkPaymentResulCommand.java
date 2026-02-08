package com.example.airbnb.payment.dto.internal;

import java.util.UUID;

import com.example.airbnb.payment.enums.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MarkPaymentResulCommand {
    private UUID paymentId;
    private PaymentStatus status;

    private String providerReference;
    private String failureReason;
}
