package com.example.airbnb.availability.dto.api;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SetAvailabilityRequest {
    @NotNull(message = "Unit ID is required")
    private UUID unitId;

    @NotNull(message = "Date is required")
    private LocalDate date;

    @NotNull(message = "Available count is required")
    private Integer availableCount;

    private BigDecimal priceOverride;

    private Boolean closed;
}
