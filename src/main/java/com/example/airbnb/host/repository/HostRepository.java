package com.example.airbnb.host.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.airbnb.host.model.Host;

public interface HostRepository extends JpaRepository<Host, UUID> {
    Optional<Host> findByUserID(UUID userId);
}
