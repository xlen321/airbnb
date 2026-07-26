package com.app.airbnb.user.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.app.airbnb.config.MapperConfiguration;
import com.app.airbnb.user.dto.request.CreateUserRequest;
import com.app.airbnb.user.dto.request.PatchUserRequest;
import com.app.airbnb.user.dto.request.UpdateUserRequest;
import com.app.airbnb.user.dto.response.UserResponse;
import com.app.airbnb.user.model.User;

@Mapper(config = MapperConfiguration.class)
public interface UserMapper {
  User toEntity(CreateUserRequest request);

  UserResponse toResponse(User user);

  void updateEntity(UpdateUserRequest request, @MappingTarget User user);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void patchEntity(PatchUserRequest request, @MappingTarget User user);
}
