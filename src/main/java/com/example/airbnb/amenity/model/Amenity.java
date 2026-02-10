package com.example.airbnb.amenity.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
    name = "amenities",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_amenity_code", columnNames = "code")
    }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Amenity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "amenity_id")
    private UUID id;

    @Column(unique = true, nullable = false, updatable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    private String description;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public static Amenity create(
            String code,
            String name,
            String description) {
        if (code == null || code.isBlank())
            throw new IllegalArgumentException("Amenity code cannot be empty");

        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Amenity name cannot be blank");

        Amenity amenity = new Amenity();
        amenity.code = code.trim().toUpperCase();
        amenity.name = name.trim();
        amenity.description = description;
        return amenity;
    }
}
