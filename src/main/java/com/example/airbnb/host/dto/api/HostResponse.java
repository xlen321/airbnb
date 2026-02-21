package com.example.airbnb.host.dto.api;

import java.util.UUID;

import com.example.airbnb.host.enums.HostStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HostResponse {
    private UUID id;
    private UUID userId;
    private HostStatus hostStatus;
}
