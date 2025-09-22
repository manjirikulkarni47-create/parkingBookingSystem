package com.manjiri.parkingBookingSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjiri.parkingBookingSystem.dto.BookingDTO;
import com.manjiri.parkingBookingSystem.model.Booking;
import com.manjiri.parkingBookingSystem.model.ParkingSpot;
import com.manjiri.parkingBookingSystem.repositories.BookingRepository;
import com.manjiri.parkingBookingSystem.repositories.ParkingSpotRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ParkingSpotService {
    
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    public Booking bookParkingSpot(Long parkingSpotId, BookingDTO bookingDTO) {

        ParkingSpot parkingSpot = parkingSpotRepository.findById(parkingSpotId)
            .orElseThrow(() -> new EntityNotFoundException("Parking spot not found"));
    
        if (!parkingSpot.getIsFree()) {
            throw new IllegalStateException("Parking spot with ID " + parkingSpotId + " is already booked.");
        }

        parkingSpot.setIsFree(false);
        parkingSpotRepository.save(parkingSpot); // Save the updated status in the database

        Booking booking = bookingRepository.save(
                Booking.builder()
                    .parkingSpot(parkingSpot)
                    .startTime(bookingDTO.getStartTime())
                    .endTime(bookingDTO.getEndTime()) // 1 hour
                    .build()
        );

        return booking;
    }

    
}
