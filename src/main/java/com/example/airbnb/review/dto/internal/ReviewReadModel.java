package com.example.airbnb.review.dto.internal;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviewReadModel {
    private UUID id;
    private UUID bookingId;
    private UUID propertyId;
    private UUID unitId;
    private UUID authorUserId;

    private int rating;
    private String comment;

    private LocalDateTime createdAt;
}
