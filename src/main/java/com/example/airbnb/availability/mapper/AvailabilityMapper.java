package com.example.airbnb.availability.mapper;

import com.example.airbnb.availability.dto.api.AvailabilityResponse;
import com.example.airbnb.availability.model.UnitAvailability;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AvailabilityMapper {
    public static AvailabilityResponse toResponse(UnitAvailability availability) {
        AvailabilityResponse response = new AvailabilityResponse();
        response.setUnitId(availability.getUnit().getId());
        response.setDate(availability.getDate());
        response.setAvailableCount(availability.getAvailableCount());
        response.setClosed(availability.getClosed());
        response.setPrice(availability.getPriceOverride());
        return response;
    }
}
