package com.example.airbnb.availability.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.airbnb.unit.model.Unit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "unit_availability", 
uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_unit_date", 
            columnNames = { "unit_id", "date" }
        )
    },
    indexes = {
        @Index(name = "idx_availability_unit", columnList = "unit_id"),
        @Index(name = "idx_availability_date", columnList = "date")
    }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UnitAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;

    @Column(nullable = false)
    private LocalDate date;

    @Column(name = "total_count", nullable = false)
    private Integer totalCount;

    @Column(name = "booked_count", nullable = false)
    private Integer bookedCount;

    @Column(name = "price_override", precision = 10, scale = 2)
    private BigDecimal priceOverride;

    @Column(nullable = false)
    private Boolean closed = false;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public static UnitAvailability createOpen(Unit unit, LocalDate date, int totalCount) {
        if(totalCount < 0)
            throw new IllegalArgumentException("Available count cannot be negative");

        UnitAvailability availability = new UnitAvailability();
        availability.unit = unit;
        availability.date = date;
        availability.totalCount = totalCount;
        availability.bookedCount = 0;
        availability.closed = false;
        return availability;
    }

    public int getAvailableCount() {
        return totalCount - bookedCount;
    }

    public void reserve(int quantity) {
        if(closed)
            throw new IllegalStateException("Date is closed.");

        if(quantity <= 0)
            throw new IllegalArgumentException("Quantity must be greater than zero.");

        if(bookedCount + quantity > totalCount)
            throw new IllegalStateException("Insufficient Availability");

        this.bookedCount += quantity;
    }

    public void release(int quantity) {
        if(quantity <= 0)
            throw new IllegalArgumentException("Quantity must be greater than zero.");

        this.bookedCount -= quantity;

        if(this.bookedCount < 0)
            this.bookedCount = 0;
    }

    public void close() {
        this.closed = true;
    }

    public void open() {
        this.closed = false;
    }

    public void overrideprice(BigDecimal price) {
        if(price == null || price.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Price must be greater than zero.");
        this.priceOverride = price;
    }

}
