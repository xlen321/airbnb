package com.example.airbnb.unit.dto.api;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateUnitRequest {
    @Size(max = 100, message = "Name must be less than 100 characters")
    private String name;

    @Min(value = 1, message = "Capacity must be at least 1")
    private Integer capacity;

    @Min(value = 1, message = "Total count must be at least 1")
    private Integer totalCount;
}
