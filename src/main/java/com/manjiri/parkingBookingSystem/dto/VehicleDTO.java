package com.manjiri.parkingBookingSystem.dto;

import com.manjiri.parkingBookingSystem.model.VehicleType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleDTO {
    
    private UserDTO userDTO;

    private String licenseNumber;

    private VehicleType vehicleType;
}
