package com.example.airbnb.host.dto.api;

import com.example.airbnb.host.enums.GovtIdType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateHostRequest {
    @NotNull(message = "Host must choose a valid govt id")
    private GovtIdType govtIdType;

    @NotBlank(message = "Host must provide a valid govt id number")
    private String govtIdNumber;
}
