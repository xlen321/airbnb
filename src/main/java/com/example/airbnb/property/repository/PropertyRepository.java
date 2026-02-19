package com.example.airbnb.property.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.airbnb.property.enums.PropertyListingStatus;
import com.example.airbnb.property.enums.PropertyVerificationStatus;
import com.example.airbnb.property.model.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, UUID> {
    Optional<Property> findByIdAndDeletedAtIsNull(UUID id);

    List<Property> findByHostIdAndDeletedAtIsNull(UUID hostId);

    List<Property> findByListingStatusAndDeletedAtIsNull(PropertyListingStatus listingStatus);

    List<Property> findByVerificationStatusAndDeletedAtIsNull(PropertyVerificationStatus verificationStatus);
}
