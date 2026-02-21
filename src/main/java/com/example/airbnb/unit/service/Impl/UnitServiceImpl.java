package com.example.airbnb.unit.service.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.airbnb.common.exception.NotFoundException;
import com.example.airbnb.common.exception.UnauthorizedException;
import com.example.airbnb.property.model.Property;
import com.example.airbnb.property.repository.PropertyRepository;
import com.example.airbnb.unit.dto.api.CreateUnitRequest;
import com.example.airbnb.unit.dto.api.UnitResponse;
import com.example.airbnb.unit.mapper.UnitMapper;
import com.example.airbnb.unit.model.Unit;
import com.example.airbnb.unit.repository.UnitRepository;
import com.example.airbnb.unit.service.UnitService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UnitServiceImpl implements UnitService {
    private final UnitRepository unitRepository;
    private final PropertyRepository propertyRepository;

    @Override
    public UnitResponse createUnit(UUID propertyId, UUID hostId, CreateUnitRequest request) {
        Property property = propertyRepository.findByIdAndDeletedAtIsNull(propertyId)
                .orElseThrow(() -> new NotFoundException("Property not found"));

        if (!property.getHost().getId().equals(hostId))
            throw new UnauthorizedException("You are not owner of this property");

        Unit unit = unitRepository.save(UnitMapper.toEntity(request, property));

        return UnitMapper.toResponse(unit);

    }

    @Override
    @Transactional(readOnly = true)
    public List<UnitResponse> getByProperty(UUID propertyId) {
        return unitRepository.findByPropertyIdAndDeletedAtNull(propertyId)
                .stream()
                .map(UnitMapper::toResponse)
                .toList();
    }

    @Override
    public UnitResponse updateInventory(UUID unitId, int totalCount) {
        Unit unit = unitRepository.findByIdAndDeletedAtNull(unitId)
                .orElseThrow(() -> new NotFoundException("Unit not found"));

        unit.updateInventory(totalCount);
        return UnitMapper.toResponse(unitRepository.save(unit));
    }

    @Override
    public void deleteUnit(UUID unitId) {
        Unit unit = unitRepository.findByIdAndDeletedAtNull(unitId)
                .orElseThrow(() -> new NotFoundException("Unit not found"));

        unit.softDelete();
    }

}
