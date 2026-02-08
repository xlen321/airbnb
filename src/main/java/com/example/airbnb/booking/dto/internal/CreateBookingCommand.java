package com.example.airbnb.booking.dto.internal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateBookingCommand {
    private UUID userId;
    private UUID unitId;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    private int guestCount;

    private List<LocalDate> bookingDates;
    private BigDecimal calculatedTotalPrice;
}
