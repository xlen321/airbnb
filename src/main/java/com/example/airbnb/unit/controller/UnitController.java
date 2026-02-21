package com.example.airbnb.unit.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.airbnb.unit.dto.api.CreateUnitRequest;
import com.example.airbnb.unit.dto.api.UnitResponse;
import com.example.airbnb.unit.service.UnitService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/unit")
@RequiredArgsConstructor
public class UnitController {
    private final UnitService unitService;

    @PostMapping("/property/{propertyId}")
    public ResponseEntity<UnitResponse> createUnit(
            @PathVariable String propertyId,
            @RequestParam String hostId,
            @Valid @RequestBody CreateUnitRequest request) {
        UnitResponse response = unitService.createUnit(
                UUID.fromString(propertyId),
                UUID.fromString(hostId),
                request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/property/{propertyId")
    public ResponseEntity<List<UnitResponse>> getByProperty(@PathVariable String propertyId) {
        return ResponseEntity.ok(unitService.getByProperty(UUID.fromString(propertyId)));
    }

    @PostMapping("/inventory/{unitId}")
    public ResponseEntity<UnitResponse> updateInventory(
            @PathVariable String unitId,
            @RequestParam int totalCount) {
        return ResponseEntity.ok(unitService.updateInventory(UUID.fromString(unitId), totalCount));
    }

    @DeleteMapping("/{unitId}")
    public ResponseEntity<Void> deleteUnit(@PathVariable String unitId) {
        unitService.deleteUnit(UUID.fromString(unitId));
        return ResponseEntity.noContent().build();
    }
}
