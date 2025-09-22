package com.manjiri.parkingBookingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjiri.parkingBookingSystem.model.CheckIn;

@Repository
public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
    
}
