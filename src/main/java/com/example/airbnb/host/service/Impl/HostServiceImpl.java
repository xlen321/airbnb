package com.example.airbnb.host.service.Impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.airbnb.common.exception.BusinessRuleViolationException;
import com.example.airbnb.common.exception.NotFoundException;
import com.example.airbnb.host.dto.api.CreateHostRequest;
import com.example.airbnb.host.dto.api.HostResponse;
import com.example.airbnb.host.mapper.HostMapper;
import com.example.airbnb.host.model.Host;
import com.example.airbnb.host.repository.HostRepository;
import com.example.airbnb.host.service.HostService;
import com.example.airbnb.user.model.User;
import com.example.airbnb.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class HostServiceImpl implements HostService {
    private final HostRepository hostRepository;
    private final UserRepository userRepository;

    @Override
    public HostResponse requestHost(CreateHostRequest request, UUID userId) {
        User user = userRepository.findByIdAndDeletedAtNull(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));

        hostRepository.findByUserID(userId)
                .ifPresent(h -> {
                    throw new BusinessRuleViolationException("Host already exists.");
                });

        Host host = HostMapper.toEntity(request, user);

        hostRepository.save(host);

        return HostMapper.toResponse(host);
    }

    @Override
    public HostResponse approveHost(UUID hostId) {
        Host host = hostRepository.findById(hostId)
                .orElseThrow(() -> new NotFoundException("Host not found"));

        host.approve();
        return HostMapper.toResponse(host);
    }

    @Override
    public HostResponse rejectHost(UUID hostId) {
        Host host = hostRepository.findById(hostId)
                .orElseThrow(() -> new NotFoundException("Host not found"));

        host.reject();
        return HostMapper.toResponse(host);
    }

    @Override
    public HostResponse suspendHost(UUID hostId) {
        Host host = hostRepository.findById(hostId)
                .orElseThrow(() -> new NotFoundException("Host not found"));

        host.suspend();
        return HostMapper.toResponse(host);
    }

    @Override
    @Transactional(readOnly = true)
    public HostResponse getByUser(UUID userId) {
        Host host = hostRepository.findByUserID(userId)
                .orElseThrow(() -> new NotFoundException("Host not found"));

        return HostMapper.toResponse(host);
    }

}
