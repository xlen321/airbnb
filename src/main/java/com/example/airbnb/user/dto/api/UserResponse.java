package com.example.airbnb.user.dto.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {
    private String id;
    private String fullName;
    private String email;
    private String role;
    
}
