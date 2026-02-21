package com.example.airbnb.guest.service;

import java.util.List;
import java.util.UUID;

import com.example.airbnb.guest.dto.api.AddGuestRequest;
import com.example.airbnb.guest.dto.api.GuestResponse;
import com.example.airbnb.guest.dto.api.UpdateGuestRequest;

public interface GuestService {
    GuestResponse addGuest(Long bookingId, AddGuestRequest request);

    List<GuestResponse> getGuestsByBooking(UUID bookingId);

    GuestResponse updateGuest(UUID bookingId, Long guestId, UpdateGuestRequest request);

    void removeGuest(UUID bookingId, Long guestId);
}
