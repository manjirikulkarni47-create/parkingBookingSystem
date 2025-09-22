package com.manjiri.parkingBookingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjiri.parkingBookingSystem.model.ParkingFloor;

@Repository
public interface ParkingFloorRepository extends JpaRepository<ParkingFloor, Long> {
    
}
