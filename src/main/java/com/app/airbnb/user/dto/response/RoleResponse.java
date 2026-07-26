package com.app.airbnb.user.dto.response;

import com.app.airbnb.user.model.enums.RoleName;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RoleResponse {
  private Long id;
  private RoleName name;
  private String description;
}