package com.example.airbnb.availability.dto.api;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AvailabilityResponse {
    private UUID unitId;
    private LocalDate date;

    private Integer availableCount;
    private BigDecimal price;
    private Boolean closed;
}
