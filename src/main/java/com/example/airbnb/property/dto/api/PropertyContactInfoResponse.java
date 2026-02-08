package com.example.airbnb.property.dto.api;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PropertyContactInfoResponse {
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    private Double latitude;
    private Double longitude;

    private String email;
    private String phone;
}
