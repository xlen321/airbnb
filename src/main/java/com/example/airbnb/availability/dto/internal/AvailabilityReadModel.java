package com.example.airbnb.availability.dto.internal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AvailabilityReadModel {
    private UUID unitId;
    private LocalDate date;

    private int availableCount;
    private BigDecimal effectivePrice;
    private boolean closed;
}
