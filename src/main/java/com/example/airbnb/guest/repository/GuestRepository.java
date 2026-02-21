package com.example.airbnb.guest.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.airbnb.guest.model.Guest;
import com.example.airbnb.booking.model.Booking;


public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByBooking(Booking booking);

    Optional<Guest> findByIdAndBookingId(Long id, UUID bookingId);

    
}
