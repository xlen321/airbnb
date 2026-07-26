package com.app.airbnb.user.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.airbnb.user.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);

  Optional<User> findByPhone(String phone);

  boolean existsByEmail(String email);

  boolean existsByPhone(String phone);

  boolean existsByEmailAndIdNot(String email, Long id);

  boolean existsByPhoneAndIdNot(String phone, Long id);
}
