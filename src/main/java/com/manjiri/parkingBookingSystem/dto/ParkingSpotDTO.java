package com.manjiri.parkingBookingSystem.dto;

import com.manjiri.parkingBookingSystem.model.VehicleType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ParkingSpotDTO {
    private Integer spotNumber;
    private Boolean isFree;
    private VehicleType supportedVehicleType;
    private Boolean hasCharger;
}
