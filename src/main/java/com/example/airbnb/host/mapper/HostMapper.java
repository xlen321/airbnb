package com.example.airbnb.host.mapper;

import com.example.airbnb.host.dto.api.CreateHostRequest;
import com.example.airbnb.host.dto.api.HostResponse;
import com.example.airbnb.host.model.Host;
import com.example.airbnb.user.model.User;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HostMapper {
    public static Host toEntity(CreateHostRequest request, User user) {
        return Host.create(
                user,
                request.getGovtIdType(),
                request.getGovtIdNumber()
            );
    }

    public static HostResponse toResponse(Host host) {
        HostResponse response = new HostResponse();
        response.setId(host.getId());
        response.setUserId(host.getUser().getId());
        response.setHostStatus(host.getHostStatus());

        return response;
    }
}
