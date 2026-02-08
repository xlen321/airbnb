package com.example.airbnb.availability.dto.api;

import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AvailabilitycalenderResponse {
    private UUID unitId;
    private List<AvailabilityResponse> days;
}
