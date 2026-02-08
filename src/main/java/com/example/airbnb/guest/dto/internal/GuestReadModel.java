package com.example.airbnb.guest.dto.internal;

import java.time.LocalDateTime;
import java.util.UUID;

import com.example.airbnb.guest.enums.GuestGender;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GuestReadModel {
private UUID id;
    private UUID bookingId;

    private String fullName;
    private GuestGender gender;
    private Integer age;

    private LocalDateTime createdAt;
}
