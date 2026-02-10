package com.example.airbnb.user.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.airbnb.user.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean exixtsByEmail(String email);
    boolean exixtsByPhone(String phone);

    Optional<User> findByEmail(String email);
    Optional<User> findByPhone(String phone);

    Optional<User> findByIdAndIsActiveTrue(UUID id);
}
