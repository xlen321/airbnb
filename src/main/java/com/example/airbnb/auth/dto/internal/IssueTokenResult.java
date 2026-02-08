package com.example.airbnb.auth.dto.internal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IssueTokenResult {
    private String accessToken;
    private String refreshToken;
    private long expiresIn;
}
