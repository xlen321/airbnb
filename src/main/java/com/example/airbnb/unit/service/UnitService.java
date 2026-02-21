package com.example.airbnb.unit.service;

import java.util.List;
import java.util.UUID;

import com.example.airbnb.unit.dto.api.CreateUnitRequest;
import com.example.airbnb.unit.dto.api.UnitResponse;

public interface UnitService {
    UnitResponse createUnit(UUID propertyId, UUID hostId, CreateUnitRequest request);

    List<UnitResponse> getByProperty(UUID propertyId);

    UnitResponse updateInventory(UUID unitId, int totalCount);

    void deleteUnit(UUID unitId);
}
