package com.example.airbnb.property.service;

import java.util.UUID;

import com.example.airbnb.property.dto.api.CreatePropertyRequest;
import com.example.airbnb.property.dto.api.PropertyResponse;
import com.example.airbnb.property.dto.api.UpdatePropertyRequest;

public interface PropertyService {
    PropertyResponse addProperty(CreatePropertyRequest request, UUID hostId);

    PropertyResponse getById(UUID id);

    PropertyResponse updateProperty(UpdatePropertyRequest request, UUID id);

    void submitForVerification(UUID id);

    void publish(UUID id);

    void softDelete(UUID id);
}
