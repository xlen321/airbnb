package com.example.airbnb.user.dto.internal;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserReadModel {
    private UUID id;
    private String fullName;
    private String email;
    private String role;

    private Boolean emailVerified;
    private Boolean phoneverified;

    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
    
}
