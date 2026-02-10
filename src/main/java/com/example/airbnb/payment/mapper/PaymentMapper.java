package com.example.airbnb.payment.mapper;

import com.example.airbnb.payment.dto.api.PaymentResponse;
import com.example.airbnb.payment.dto.internal.PaymentReadModel;
import com.example.airbnb.payment.model.Payment;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentMapper {
    public static PaymentResponse toResponse(Payment payment) {
        PaymentResponse response = new PaymentResponse();
        response.setPaymentId(payment.getId());
        response.setBookingId(payment.getBooking().getId());
        response.setAmount(payment.getAmount());
        response.setPaymentMethod(payment.getPaymentMethod());
        response.setStatus(payment.getPaymentStatus());
        response.setPaymentReference(payment.getPaymentReference());
        response.setCreatedAt(payment.getCreatedAt());
        return response;
    }

    public static PaymentReadModel toReadModel(Payment payment) {
        return new PaymentReadModel(
                payment.getId(),
                payment.getBooking().getId(),
                payment.getUser().getId(),
                payment.getAmount(),
                payment.getPaymentMethod(),
                payment.getPaymentStatus(),
                payment.getPaymentReference(),
                payment.getProviderReference(),
                payment.getCreatedAt()
            );
    }
}
