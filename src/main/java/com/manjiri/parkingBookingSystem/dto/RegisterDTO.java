package com.manjiri.parkingBookingSystem.dto;

import com.manjiri.parkingBookingSystem.model.UserRole;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
    @NotBlank
    private String lastName;

    @NotBlank
    private String firstName;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String mobileNumber;

    @NotBlank
    private String countryCode;

    @NotBlank
    private UserRole userRole;
}
