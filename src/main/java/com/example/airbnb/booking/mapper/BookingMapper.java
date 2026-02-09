package com.example.airbnb.booking.mapper;

import com.example.airbnb.booking.dto.api.BookingResponse;
import com.example.airbnb.booking.dto.api.BookingSummaryResponse;
import com.example.airbnb.booking.dto.internal.BookingReadModel;
import com.example.airbnb.booking.model.Booking;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookingMapper {
    public static BookingResponse toResponse(Booking booking) {
        BookingResponse response = new BookingResponse();
        response.setBookingId(booking.getId());
        response.setUnitId(booking.getUnit().getId());
        response.setCheckInDate(booking.getChckInDate());
        response.setCheckOutDate(booking.getCheckOutDate());
        response.setGuestCount(booking.getGuestCount());
        response.setTotalPrice(booking.getTotalPrice());
        response.setStatus(booking.getStatus());
        return response;
    }

    public static BookingSummaryResponse toSummaryResponse(Booking booking) {
        BookingSummaryResponse response = new BookingSummaryResponse();
        response.setBookingId(booking.getId());
        response.setUnitId(booking.getUnit().getId());
        response.setCheckInDate(booking.getChckInDate());
        response.setCheckOutDate(booking.getCheckOutDate());
        response.setStatus(booking.getStatus());
        return response;
    }

    public static BookingReadModel toReadModel(Booking booking) {
        return new BookingReadModel(
                booking.getId(),
                booking.getUser().getId(),
                booking.getUnit().getId(),
                booking.getChckInDate(),
                booking.getCheckOutDate(),
                booking.getGuestCount(),
                booking.getTotalPrice(),
                booking.getStatus());
    }
}
