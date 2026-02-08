package com.example.airbnb.booking.dto.internal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.example.airbnb.booking.enums.BookingStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookingReadModel {
    private UUID bookingId;
    private UUID userId;
    private UUID unitId;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    private int guestCount;
    private BigDecimal totalPrice;

    private BookingStatus status;
}
