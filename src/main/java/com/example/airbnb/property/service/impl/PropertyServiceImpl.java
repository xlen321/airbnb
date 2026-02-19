package com.example.airbnb.property.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.airbnb.common.exception.NotFoundException;
import com.example.airbnb.common.exception.UnauthorizedException;
import com.example.airbnb.property.dto.api.CreatePropertyRequest;
import com.example.airbnb.property.dto.api.PropertyResponse;
import com.example.airbnb.property.dto.api.UpdatePropertyRequest;
import com.example.airbnb.property.mapper.PropertyMapper;
import com.example.airbnb.property.model.Property;
import com.example.airbnb.property.model.PropertyContactInfo;
import com.example.airbnb.property.repository.PropertyRepository;
import com.example.airbnb.property.service.PropertyService;
import com.example.airbnb.user.enums.UserRole;
import com.example.airbnb.user.model.User;
import com.example.airbnb.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepository propertyRepository;
    private final UserRepository userRepository;

    @Override
    public PropertyResponse addProperty(CreatePropertyRequest request, UUID hostId) {
        User host = userRepository.findByIdAndDeletedAtNull(hostId)
                .orElseThrow(() -> new NotFoundException("User not found"));

        if (host.getEmailVerified() == false || host.getPhoneverified() == false)
            throw new UnauthorizedException("User must verify email or phone before registering a property");

        if (host.getRole() != UserRole.HOST)
            throw new UnauthorizedException("User must be a host to register a property");

        PropertyContactInfo propertyContactInfo = PropertyMapper.toContactInfo(request.getContactInfo());

        Property property = Property.createDraft(request.getName(), propertyContactInfo, host);

        propertyRepository.save(property);

        return PropertyMapper.toResponse(property);
    }

    @Override
    @Transactional(readOnly = true)
    public PropertyResponse getById(UUID id) {
        Property property = propertyRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new NotFoundException("Property not found"));

        return PropertyMapper.toResponse(property);
    }

    @Override
    public PropertyResponse updateProperty(UpdatePropertyRequest request, UUID id) {
        Property property = propertyRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new NotFoundException("Property not found"));

        property.setName(request.getName());
        property.setContactInfo(PropertyMapper.toContactInfo(request.getContactInfo()));

        return PropertyMapper.toResponse(property);
    }

    @Override
    public void submitForVerification(UUID id) {
        Property property = propertyRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new NotFoundException("Property not found"));

        property.submitForVerification();
    }

    @Override
    public void publish(UUID id) {
        Property property = propertyRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new NotFoundException("Property not found"));

        property.publish();
    }

    @Override
    public void softDelete(UUID id) {
        Property property = propertyRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new NotFoundException("Property not found"));

        property.softDelete();
    }

}
