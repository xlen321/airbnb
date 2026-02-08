package com.example.airbnb.auth.dto.internal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthenticateUserCommand {
    private String identifier;
    private String secret;
}
