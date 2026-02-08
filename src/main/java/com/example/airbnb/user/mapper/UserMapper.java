package com.example.airbnb.user.mapper;

import com.example.airbnb.user.dto.api.CreateUserRequest;
import com.example.airbnb.user.dto.api.UserResponse;
import com.example.airbnb.user.dto.internal.UserReadModel;
import com.example.airbnb.user.model.User;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserMapper {

    // API DTO -> Entity
    public static User toEntity(CreateUserRequest request) {
        return User.createLocalUser(
                request.getFullName(),
                request.getEmail(),
                request.getPassword(),
                request.getPhoneNumber());
    }

    public static UserResponse toresponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId().toString());
        response.setFullName(user.getFullName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole().name());
        return response;
    }

    public static UserReadModel toReadModel(User user) {
        return new UserReadModel(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getRole().name(),
                user.getEmailVerified(),
                user.getPhoneverified(),
                user.getCreatedAt(),
                user.getDeletedAt());
    }

}
