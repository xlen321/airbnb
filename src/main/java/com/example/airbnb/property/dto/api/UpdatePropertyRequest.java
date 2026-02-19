package com.example.airbnb.property.dto.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdatePropertyRequest {
    @NotBlank(message = "Name is required")
    @Size(max = 30, message = "Name must be less than 30 characters")
    private String name;

    @NotNull
    private PropertyContactInfoRequest contactInfo;
}
