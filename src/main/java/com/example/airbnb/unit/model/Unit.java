package com.example.airbnb.unit.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.airbnb.amenity.model.Amenity;
import com.example.airbnb.common.exception.BusinessRuleViolationException;
import com.example.airbnb.property.model.Property;
import com.example.airbnb.unit.enums.UnitTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "units")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    @Column(nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "unit_type", nullable = false)
    private UnitTypes unitType;

    @Column(nullable = false)
    private Integer capacity;

    @Column(name = "base_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal basePrice;

    @Column(name = "total_count", nullable = false)
    private Integer totalCount;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "unit_amenities", joinColumns = @JoinColumn(name = "unit_id"), inverseJoinColumns = @JoinColumn(name = "amenity_id"))
    private Set<Amenity> amenities = new HashSet<>();

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    public static Unit create(Property property, String name, int capacity, int totalCount, UnitTypes unitType,
            BigDecimal basePrice) {

        if (property == null)
            throw new BusinessRuleViolationException("Property is required");
        if (capacity <= 0)
            throw new BusinessRuleViolationException("Capacity must be greater than zero");

        if (totalCount <= 0)
            throw new BusinessRuleViolationException("Total count must be greater then zero ");

        if (basePrice == null || basePrice.compareTo(BigDecimal.ZERO) <= 0)
            throw new BusinessRuleViolationException("Base price must be greater than zero");

        Unit unit = new Unit();
        unit.property = property;
        unit.name = name;
        unit.capacity = capacity;
        unit.totalCount = totalCount;
        unit.unitType = unitType;
        unit.basePrice = basePrice;
        return unit;
    }

    public void updateCapacity(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("Capacity must be greater than zero");
        this.capacity = capacity;
    }

    public void updateInventory(int totalCount) {
        if (totalCount <= 0)
            throw new IllegalArgumentException("Total count must be greater then zero ");
        this.totalCount = totalCount;
    }

    public void softDelete() {
        this.deletedAt = LocalDateTime.now();
    }

    public boolean isDeleted() {
        return deletedAt != null;
    }
}
