package com.example.airbnb.property.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.airbnb.amenity.model.Amenity;
import com.example.airbnb.property.enums.PropertyListingStatus;
import com.example.airbnb.property.enums.PropertyVerificationStatus;
import com.example.airbnb.user.model.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
    name = "properties", 
    indexes = {
        @Index(name = "idx_property_verification_status", columnList = "verification_status"),
        @Index(name = "idx_property_listing_status", columnList = "listing_status")
    }
)
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    @Embedded
    private PropertyContactInfo contactInfo;

    @OneToMany(
        mappedBy = "property", 
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    private List<PropertyImage> images = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "property_amenities", 
        joinColumns = @JoinColumn(name = "property_id"), 
        inverseJoinColumns = @JoinColumn(name = "amenity_id")
    )
    private Set<Amenity> amenities = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "verification_status", nullable = false)
    private PropertyVerificationStatus verificationStatus = PropertyVerificationStatus.DRAFT;

    @Enumerated(EnumType.STRING)
    @Column(name = "listing_status", nullable = false)
    private PropertyListingStatus listingStatus = PropertyListingStatus.UNLISTED;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "host_id", nullable = false)
    private User host;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    public static Property createDraft(String name, PropertyContactInfo contactInfo, User hostId) {
        Property property = new Property();
        property.name = name;
        property.contactInfo = contactInfo;
        property.host = hostId;
        property.verificationStatus = PropertyVerificationStatus.DRAFT;
        property.listingStatus = PropertyListingStatus.UNLISTED;
        return property;
    }

    public void submitForVerification() {
        if (verificationStatus != PropertyVerificationStatus.DRAFT)
            throw new IllegalStateException("Property not in DRAFT state");
        this.verificationStatus = PropertyVerificationStatus.UNDER_VERIFICATION;
    }

    public void verify() {
        if (verificationStatus != PropertyVerificationStatus.UNDER_VERIFICATION)
            throw new IllegalStateException("Property not in UNDER_VERIFICATION state");
        this.verificationStatus = PropertyVerificationStatus.VERIFIED;
    }

    public void reject() {
        if (verificationStatus != PropertyVerificationStatus.UNDER_VERIFICATION)
            throw new IllegalStateException("Property not in UNDER_VERIFICATION state");
        this.verificationStatus = PropertyVerificationStatus.REJECTED;
    }

    public void publish() {
        if (verificationStatus != PropertyVerificationStatus.VERIFIED)
            throw new IllegalStateException("Property not in VERIFIED state");
        this.listingStatus = PropertyListingStatus.PUBLISHED;
    }

    public void unlist() {
        this.listingStatus = PropertyListingStatus.UNLISTED;
    }

    public void suspend() {
        this.listingStatus = PropertyListingStatus.SUSPENDED;
    }

    public void softDelete() {
        this.deletedAt = LocalDateTime.now();
    }

    public boolean isDeleted() {
        return deletedAt != null;
    }
}
