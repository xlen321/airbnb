package com.example.airbnb.booking.dto.internal;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CancelBookingCommand {
    private UUID bookingId;
    private UUID userId;
    private String reason;
}
