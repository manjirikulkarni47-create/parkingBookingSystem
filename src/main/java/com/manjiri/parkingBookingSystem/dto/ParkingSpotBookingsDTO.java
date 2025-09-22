package com.manjiri.parkingBookingSystem.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ParkingSpotBookingsDTO {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isBooked;
}
