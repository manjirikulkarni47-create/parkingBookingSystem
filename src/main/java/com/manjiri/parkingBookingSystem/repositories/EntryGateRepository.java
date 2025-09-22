package com.manjiri.parkingBookingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjiri.parkingBookingSystem.model.EntryGate;

@Repository
public interface EntryGateRepository extends JpaRepository<EntryGate, Long> {
    
}
