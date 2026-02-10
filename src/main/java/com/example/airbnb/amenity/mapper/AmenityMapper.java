package com.example.airbnb.amenity.mapper;

import com.example.airbnb.amenity.dto.AmenityResponse;
import com.example.airbnb.amenity.model.Amenity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AmenityMapper {
    public static AmenityResponse toResponse(Amenity amenity) {
        AmenityResponse response = new AmenityResponse();
        response.setId(amenity.getId());
        response.setCode(amenity.getCode());
        response.setName(amenity.getName());
        response.setDescription(amenity.getDescription());
        return response;
    }
}
