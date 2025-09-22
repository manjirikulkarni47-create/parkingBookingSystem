package com.manjiri.parkingBookingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjiri.parkingBookingSystem.model.ExitGate;

@Repository
public interface ExitGateRepository extends JpaRepository<ExitGate, Long> {
    
}
