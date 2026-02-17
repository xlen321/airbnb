package com.example.airbnb.user.service.impl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.airbnb.common.exception.ConflictException;
import com.example.airbnb.common.exception.NotFoundException;
import com.example.airbnb.user.dto.api.CreateUserRequest;
import com.example.airbnb.user.dto.api.UpdateUserRequest;
import com.example.airbnb.user.dto.api.UserResponse;
import com.example.airbnb.user.mapper.UserMapper;
import com.example.airbnb.user.model.User;
import com.example.airbnb.user.repository.UserRepository;
import com.example.airbnb.user.service.UserService;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponse register(CreateUserRequest request) {
        if (userRepository.existsByEmail(request.getEmail()))
            throw new ConflictException("User with provided email already exixts.");
        
        if (userRepository.existsByPhone(request.getPhoneNumber()))
            throw new ConflictException("User with provided phone number already exixts.");

        User user = UserMapper.toEntity(request);

        userRepository.save(user);

        return UserMapper.toresponse(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUserById(UUID id) {
        User user = userRepository.findByIdAndDeletedAtNull(id)
                .orElseThrow(() -> new NotFoundException("User not found."));
        return UserMapper.toresponse(user);
    }

    @Override
    public UserResponse updateProfile(UpdateUserRequest request, UUID id) {
        User user = userRepository.findByIdAndDeletedAtNull(id)
                .orElseThrow(() -> new NotFoundException("User not found."));

        if (!user.getEmail().equalsIgnoreCase(request.getEmail())
                && userRepository.existsByEmail(request.getEmail().toLowerCase()))
            throw new ConflictException("Email already exists");

        if (!user.getPhone().equalsIgnoreCase(request.getPhoneNumber())
                && userRepository.existsByPhone(request.getPhoneNumber()))
            throw new ConflictException("Phone number already exists");

        user.setFullName(request.getFullName());
        user.setPhone(request.getPhoneNumber());
        user.setEmail(request.getEmail());

        userRepository.save(user);

        return UserMapper.toresponse(user);
    }

    @Override
    public void deactivate(UUID id) {
        User user = userRepository.findByIdAndDeletedAtNull(id)
                .orElseThrow(() -> new NotFoundException("User not found"));

        user.setDeletedAt(LocalDateTime.now());

        userRepository.save(user);
    }

}
