package com.manjiri.parkingBookingSystem.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjiri.parkingBookingSystem.model.Booking;
import com.manjiri.parkingBookingSystem.model.ParkingSpot;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByParkingSpotAndEndTimeAfter(ParkingSpot parkingSpot, LocalDateTime endTime);

}
