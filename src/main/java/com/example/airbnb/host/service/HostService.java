package com.example.airbnb.host.service;

import java.util.UUID;

import com.example.airbnb.host.dto.api.CreateHostRequest;
import com.example.airbnb.host.dto.api.HostResponse;

public interface HostService {
    HostResponse requestHost(CreateHostRequest request, UUID userId);

    HostResponse approveHost(UUID hostId);

    HostResponse rejectHost(UUID hostId);

    HostResponse suspendHost(UUID hostId);

    HostResponse getByUser(UUID userId);
}
