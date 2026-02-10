package com.example.airbnb.guest.mapper;

import com.example.airbnb.guest.dto.api.GuestResponse;
import com.example.airbnb.guest.model.Guest;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GuestMapper {
    public static GuestResponse toResponse(Guest guest) {
        GuestResponse response = new GuestResponse();
        response.setId(guest.getId());
        response.setFullName(guest.getFullName());
        response.setAge(guest.getAge());
        response.setGender(guest.getGender());
        return response;
    }
}
