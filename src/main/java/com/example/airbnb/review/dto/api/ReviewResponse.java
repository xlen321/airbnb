package com.example.airbnb.review.dto.api;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewResponse {
    private UUID id;
    private int rating;
    private String comment;

    private UUID authorUserId;
    private LocalDateTime createdAt;
}
