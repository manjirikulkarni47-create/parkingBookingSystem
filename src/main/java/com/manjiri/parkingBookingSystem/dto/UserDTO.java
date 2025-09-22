package com.manjiri.parkingBookingSystem.dto;


import com.manjiri.parkingBookingSystem.model.UserRole;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String mobileNumber;
    private String countryCode;
    private UserRole userRole;
}
