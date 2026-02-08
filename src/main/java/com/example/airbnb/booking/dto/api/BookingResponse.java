package com.example.airbnb.booking.dto.api;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.example.airbnb.booking.enums.BookingStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookingResponse {
    private UUID bookingId;
    private UUID unitId;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    private int guestCount;
    private BigDecimal totalPrice;

    private BookingStatus status;
}
