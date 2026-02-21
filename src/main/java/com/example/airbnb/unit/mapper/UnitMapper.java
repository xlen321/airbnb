package com.example.airbnb.unit.mapper;

import com.example.airbnb.property.model.Property;
import com.example.airbnb.unit.dto.api.CreateUnitRequest;
import com.example.airbnb.unit.dto.api.UnitResponse;
import com.example.airbnb.unit.dto.internal.UnitReadModel;
import com.example.airbnb.unit.model.Unit;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UnitMapper {
    public static Unit toEntity(CreateUnitRequest request, Property property) {
        return Unit.create(
                property,
                request.getName(),
                request.getCapacity(),
                request.getTotalCount(),
                request.getUnitType(),
                request.getBasePrice()
            );
    }

    public static UnitResponse toResponse(Unit unit) {
        UnitResponse response = new UnitResponse();
        response.setId(unit.getId());
        response.setPropertyId(unit.getProperty().getId());
        response.setName(unit.getName());
        response.setCapacity(unit.getCapacity());
        response.setTotalCount(unit.getTotalCount());
        return response;
    }

    public static UnitReadModel toReadModel(Unit unit) {
        return new UnitReadModel(
                unit.getId(),
                unit.getProperty().getId(),
                unit.getName(),
                unit.getCapacity(),
                unit.getTotalCount(),
                unit.isDeleted(),
                unit.getCreatedAt(),
                unit.getDeletedAt()
            );
    }
}
