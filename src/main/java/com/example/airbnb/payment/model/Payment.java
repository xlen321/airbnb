package com.example.airbnb.payment.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.airbnb.booking.model.Booking;
import com.example.airbnb.payment.enums.PaymentMethod;
import com.example.airbnb.payment.enums.PaymentStatus;
import com.example.airbnb.user.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
    name = "payments", 
    indexes = {
        @Index(name = "idx_payment_booking", columnList = "booking_id"),
        @Index(name = "idx_payment_user", columnList = "user_id"),
        @Index(name = "idx_payment_status", columnList = "payment_status"),
        @Index(name = "idx_payment_reference", columnList = "payment_reference", unique = true)
    }
)
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false)
    private PaymentStatus paymentStatus = PaymentStatus.INITIATED;

    @Column(name = "payment_reference", length = 100)
    private String paymentReference;

    @Column(name = "provider_reference", length = 100)
    private String providerReference;

    @Column(name = "faliure_reason", length = 500)
    private String faliureReason;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;


    public static Payment initiate(Booking booking, User user, BigDecimal amount, PaymentMethod method) {
        if(amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Payment amount must be greater than zero");
        Payment payment = new Payment();
        payment.booking = booking;
        payment.user = user;
        payment.amount = amount;
        payment.paymentMethod = method;
        payment.paymentStatus = PaymentStatus.INITIATED;
        return payment;
    }

    public void markSuccessful(String providerReference) {
        if(paymentStatus != PaymentStatus.INITIATED)
            throw new IllegalStateException("Payment is not in the INITIATED state");
        this.paymentStatus = PaymentStatus.SUCCESS;
        this.providerReference = providerReference;
    }

    public void markFailed(String failureReason) {
        if(paymentStatus != PaymentStatus.INITIATED)
            throw new IllegalStateException("Payment is not in the INITIATED state");
        this.paymentStatus = PaymentStatus.FAILED;
        this.faliureReason = failureReason;
    }

    public void markRefunded() {
        if(paymentStatus != PaymentStatus.SUCCESS)
            throw new IllegalStateException("Only successful payments can be refunded");
        this.paymentStatus = PaymentStatus.REFUNDED;
    }
}
