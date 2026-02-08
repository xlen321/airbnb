package com.example.airbnb.booking.dto.api;

import java.time.LocalDate;
import java.util.UUID;

import com.example.airbnb.booking.enums.BookingStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookingSummaryResponse {
    private UUID bookingId;
    private UUID unitId;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    private BookingStatus status;
}
