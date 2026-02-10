package com.example.airbnb.review.mapper;

import com.example.airbnb.review.dto.api.ReviewResponse;
import com.example.airbnb.review.dto.api.ReviewSummaryResponse;
import com.example.airbnb.review.dto.internal.ReviewReadModel;
import com.example.airbnb.review.model.Review;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewMapper {
    public static ReviewResponse toResponse(Review review) {
        ReviewResponse response = new ReviewResponse();
        response.setId(review.getId());
        response.setRating(review.getRating());
        response.setComment(review.getComment());
        response.setCreatedAt(review.getCreatedAt());
        response.setAuthorUserId(response.getAuthorUserId());
        return response;
    }

    public static ReviewSummaryResponse toSummaryResponse(Review review) {
        ReviewSummaryResponse response = new ReviewSummaryResponse();
        response.setId(review.getId());
        response.setRating(review.getRating());
        response.setComment(review.getComment());
        response.setCreatedAt(review.getCreatedAt());
        return response;
    }

    public static ReviewReadModel toReadModel(Review review) {
        return new ReviewReadModel(
                review.getId(),
                review.getBooking().getId(),
                review.getProperty().getId(),
                review.getReviewer().getId(),
                review.getRating(),
                review.getComment(),
                review.getCreatedAt());
    }
}
