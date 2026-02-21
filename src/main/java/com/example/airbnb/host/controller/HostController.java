package com.example.airbnb.host.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.airbnb.host.dto.api.CreateHostRequest;
import com.example.airbnb.host.dto.api.HostResponse;
import com.example.airbnb.host.service.HostService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/host")
@RequiredArgsConstructor
public class HostController {
    private final HostService hostService;

    @PostMapping("/request/{userId}")
    public ResponseEntity<HostResponse> requestHost(
            @PathVariable String userId,
            @Valid @RequestBody CreateHostRequest request) {
        HostResponse response = hostService.requestHost(request, UUID.fromString(userId));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/approve/{hostId}")
    public ResponseEntity<HostResponse> approveHost(@PathVariable String hostId) {
        HostResponse response = hostService.approveHost(UUID.fromString(hostId));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/reject/{hostId}")
    public ResponseEntity<HostResponse> rejectHost(@PathVariable String hostId) {
        HostResponse response = hostService.rejectHost(UUID.fromString(hostId));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/suspend/{hostId}")
    public ResponseEntity<HostResponse> suspendHost(@PathVariable String hostId) {
        HostResponse response = hostService.suspendHost(UUID.fromString(hostId));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<HostResponse> getByUser(@PathVariable String userId) {
        HostResponse response = hostService.getByUser(UUID.fromString(userId));
        return ResponseEntity.ok(response);
    }
}
