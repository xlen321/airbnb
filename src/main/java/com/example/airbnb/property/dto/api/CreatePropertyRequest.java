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
public class CreatePropertyRequest {
    @NotBlank
    @Size(max = 30, message = "Name must not exceed 30 characters")
    private String name;

    @NotNull(message = "Contact info is required")
    private PropertyContactInfoRequest contactInfo;
}
