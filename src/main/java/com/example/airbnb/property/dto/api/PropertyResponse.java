package com.example.airbnb.property.dto.api;

import java.util.UUID;

import com.example.airbnb.property.enums.PropertyListingStatus;
import com.example.airbnb.property.enums.PropertyVerificationStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PropertyResponse {
    private UUID id;
    private String name;

    private PropertyVerificationStatus verificationStatus;
    private PropertyListingStatus listingStatus;

    private PropertyContactInfoResponse contactInfo;
}
