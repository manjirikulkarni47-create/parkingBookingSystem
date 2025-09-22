package com.manjiri.parkingBookingSystem.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingFloorDTO {
    private Integer floorNumber;
    private List<ParkingSpotDTO> parkingSpots;
}
