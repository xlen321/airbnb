package com.example.airbnb.unit.dto.internal;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class UnitReadModel {
    private UUID id;
    private UUID propertyId;

    private String name;
    private int capacity;
    private int totalCount;

    private boolean deleted;

    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
}
