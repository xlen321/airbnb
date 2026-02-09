package com.example.airbnb.booking.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.airbnb.booking.enums.BookingStatus;
import com.example.airbnb.unit.model.Unit;
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
    name = "bookings",
    indexes = {
        @Index(name = "idx_booking_user", columnList = "user_id"),
        @Index(name = "idx_booking_unit", columnList = "unit_id"),
        @Index(name = "idx_booking_date", columnList = "check_in_date, check_out_date")
    }
)
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;

    @Column(name = "check_in_date", nullable = false)
    private LocalDate chckInDate;

    @Column(name = "check_out_date", nullable = false)
    private LocalDate checkOutDate;

    @Column(name = "guest_count", nullable = false)
    private Integer guestCount;

    @Column(name = "total_price", nullable = false, precision = 12, scale = 2)
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingStatus status = BookingStatus.PENDING;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "cancelled_at")
    private LocalDateTime cancelledAt;


    public static Booking createPendingpayment(User user, Unit unit, LocalDate checkInDate, LocalDate checkOutDate, int guestCount, BigDecimal totalPrice) {
        if(!checkOutDate.isAfter(checkInDate))
            throw new IllegalArgumentException("Check-out must be after checl-in");

        if(guestCount <= 0 || guestCount > unit.getCapacity())
            throw new IllegalArgumentException("Invalid guest count");

        if(totalPrice.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Total price must be greater than zero");

        Booking booking = new Booking();
        booking.user = user;
        booking.unit = unit;
        booking.chckInDate = checkInDate;
        booking.checkOutDate = checkOutDate;
        booking.guestCount = guestCount;
        booking.totalPrice = totalPrice;
        booking.status = BookingStatus.PENDING;
        return booking;
    }

    public void confirmPayment() {
        if(status != BookingStatus.PENDING)
            throw new IllegalStateException("Booking is not pending payment");
        this.status = BookingStatus.COMPLETED;
    }

    public void cancelByUser() {
        if(status != BookingStatus.PENDING && status != BookingStatus.CONFIRMED)
            throw new IllegalStateException("Booking cannot be cancelled");
        this.status = BookingStatus.CANCELLED;
    }

    public void markCompleted() {
        if(status != BookingStatus.CONFIRMED)
            throw new IllegalStateException("Only confirmed bookings can be completed");
        this.status = BookingStatus.COMPLETED;
    }
}
