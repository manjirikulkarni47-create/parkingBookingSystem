package com.manjiri.parkingBookingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjiri.parkingBookingSystem.model.ParkingSpot;


@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {
    
}
