package com.example.airbnb.review.dto.api;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewSummaryResponse {
    private Long id;
    private int rating;
    private String comment;
    private LocalDateTime createdAt;
}
