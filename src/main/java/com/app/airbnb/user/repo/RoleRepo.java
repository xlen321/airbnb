package com.app.airbnb.user.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.airbnb.user.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
  Optional<Role> findByName(String roleName);
}
