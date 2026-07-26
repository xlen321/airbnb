package com.app.airbnb.user.service;

import java.util.List;

import com.app.airbnb.user.dto.request.CreateUserRequest;
import com.app.airbnb.user.dto.request.PatchUserRequest;
import com.app.airbnb.user.dto.request.UpdateUserRequest;
import com.app.airbnb.user.dto.response.UserResponse;

public interface UserService {
  UserResponse createUser(CreateUserRequest request);

  UserResponse getUserById(Long id);

  List<UserResponse> getAllUsers();

  UserResponse updateUser(Long id, UpdateUserRequest request);

  UserResponse patchUser(Long id, PatchUserRequest request);

  void deleteUser(Long id);

}
