package com.example.airbnb.property.mapper;

import com.example.airbnb.property.dto.api.CreatePropertyRequest;
import com.example.airbnb.property.dto.api.PropertyContactInfoRequest;
import com.example.airbnb.property.dto.api.PropertyResponse;
import com.example.airbnb.property.dto.internal.PropertyReadModel;
import com.example.airbnb.property.model.Property;
import com.example.airbnb.property.model.PropertyContactInfo;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PropertyMapper {
    public static Property toEntity(CreatePropertyRequest request) {
        return Property.createDraft(
                request.getName(),
                toContactInfo(request.getContactInfo()));
    }

    private static PropertyContactInfo toContactInfo(PropertyContactInfoRequest request) {
        PropertyContactInfo info = new PropertyContactInfo();
        info.setAddressLine1(request.getAddressLine1());
        info.setAddressLine2(request.getAddressLine1());
        info.setCity(request.getCity());
        info.setState(request.getState());
        info.setCountry(request.getCountry());
        info.setZipCode(request.getZipCode());
        info.setLatitude(request.getLatitude());
        info.setLongitude(request.getLongitude());
        info.setEmail(request.getEmail());
        info.setPhone(request.getPhone());
        return info;
    }

    public static PropertyResponse toResponse(Property property) {
        PropertyResponse response = new PropertyResponse();
        response.setId(property.getId());
        response.setName(property.getName());
        response.setVerificationStatus(property.getVerificationStatus());
        response.setListingStatus(property.getListingStatus());
        return response;
    }

    public static PropertyReadModel toReadModel(Property property) {
        return new PropertyReadModel(
                property.getId(),
                property.getName(),
                property.getVerificationStatus(),
                property.getListingStatus(),
                property.isDeleted(),
                property.getCreatedAt(),
                property.getDeletedAt());
    }
}
