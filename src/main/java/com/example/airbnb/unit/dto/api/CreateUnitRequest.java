package com.example.airbnb.unit.dto.api;

import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUnitRequest {
    @NotNull(message = "Property id is required")
    private UUID propertyId;
    
    @NotBlank(message = "Name is required")
    @Size(max = 100)
    private String name;
    
    @NotNull(message = "Capacity is required")
    @Min(value = 1, message = "Capacity must be at least 1")
    private int capacity;
    
    @NotNull(message = "Total count is required")
    @Min(value = 1, message = "Total count must be at least 1")
    private int totalCount;
}
