package com.manjiri.parkingBookingSystem.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingDTO {

    private UserDTO userDTO;

    private ParkingSpotDTO parkingSpotDTO;

    private VehicleDTO vehicleDTO;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}
