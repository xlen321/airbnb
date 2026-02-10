package com.example.airbnb.amenity.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AmenityResponse {
    private UUID id;
    private String code;
    private String name;
    private String description;
}
