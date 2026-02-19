package com.example.airbnb.user.service;

import java.util.UUID;


import com.example.airbnb.user.dto.api.CreateUserRequest;
import com.example.airbnb.user.dto.api.UpdateUserRequest;
import com.example.airbnb.user.dto.api.UserResponse;


public interface UserService {
    UserResponse register(CreateUserRequest request);

    UserResponse getUserById(UUID id);

    UserResponse updateProfile(UpdateUserRequest request, UUID id);

    void deactivate(UUID id);
}
