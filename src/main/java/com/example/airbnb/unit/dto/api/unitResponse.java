package com.example.airbnb.unit.dto.api;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class unitResponse {
    private UUID id;
    private UUID propertyId;

    private String name;
    private int capacity;
    private int totalCount;
}
