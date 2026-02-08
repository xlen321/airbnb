package com.example.airbnb.property.dto.internal;

import java.time.LocalDateTime;
import java.util.UUID;

import com.example.airbnb.property.enums.PropertyListingStatus;
import com.example.airbnb.property.enums.PropertyVerificationStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PropertyReadModel {
    private UUID id;
    private String name;

    private PropertyVerificationStatus verificationStatus;
    private PropertyListingStatus listingStatus;

    private boolean deleted;

    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
}
