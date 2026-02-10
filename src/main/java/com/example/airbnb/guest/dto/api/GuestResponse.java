package com.example.airbnb.guest.dto.api;


import com.example.airbnb.guest.enums.GuestGender;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GuestResponse {
    private Long id;
    private String fullName;
    private GuestGender gender;
    private Integer age;
}
