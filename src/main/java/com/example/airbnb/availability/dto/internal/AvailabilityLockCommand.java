package com.example.airbnb.availability.dto.internal;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AvailabilityLockCommand {
    private UUID unitId;
    private List<LocalDate> dates;
    private int quantity;
}
