package com.app.airbnb.user.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.airbnb.exception.ConflictException;
import com.app.airbnb.exception.ResourceNotFoundException;
import com.app.airbnb.user.dto.request.CreateUserRequest;
import com.app.airbnb.user.dto.request.PatchUserRequest;
import com.app.airbnb.user.dto.request.UpdateUserRequest;
import com.app.airbnb.user.dto.response.UserResponse;
import com.app.airbnb.user.mapper.UserMapper;
import com.app.airbnb.user.model.enums.Role;
import com.app.airbnb.user.model.User;
import com.app.airbnb.user.repo.UserRepo;
import com.app.airbnb.user.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepo userRepo;
  private final UserMapper mapper;

  @Override
  public UserResponse createUser(CreateUserRequest request) {
    log.debug("[Service] createUser - start, email: {}, phone: {}",
        request.getEmail(), request.getPhone());

    // check user with email & phone alreay exists
    validateEmail(request.getEmail());
    validateEmail(request.getPhone());

    // map to entity
    User user = mapper.toEntity(request);

    // set default role
    user.setRoles(Set.of(Role.ROLE_USER));

    // saving the user
    User savedUser = userRepo.save(user);

    log.debug("[Service] createUser - end, id: {}", savedUser.getId());

    return mapper.toResponse(savedUser);

  }

  @Override
  public UserResponse getUserById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
  }

  @Override
  public List<UserResponse> getAllUsers() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
  }

  @Override
  public UserResponse updateUser(Long id, UpdateUserRequest request) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
  }

  @Override
  public UserResponse patchUser(Long id, PatchUserRequest request) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'patchUser'");
  }

  @Override
  public void deleteUser(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
  }

  /*---------------------Helper Methods-----------------*/
  private User getUser(Long id) {
    return userRepo
        .findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(
            "User not found with id:" + id,
            HttpStatus.NOT_FOUND));
  }

  private void validateEmail(String email) {
    if (userRepo.existsByEmail(email))
      throw new ConflictException("User already exists with email:" + email);
  }

  private void validatePhone(String phone) {
    if (userRepo.existsByPhone(phone))
      throw new ConflictException("User already exists with phone:" + phone);
  }

}
