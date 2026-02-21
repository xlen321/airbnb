package com.example.airbnb.unit.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.airbnb.unit.model.Unit;

public interface UnitRepository extends JpaRepository<Unit, UUID> {
    List<Unit> findByPropertyIdAndDeletedAtNull(UUID propertyId);

    Optional<Unit> findByIdAndDeletedAtNull(UUID id);
}
