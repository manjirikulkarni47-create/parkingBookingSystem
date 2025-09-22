package com.manjiri.parkingBookingSystem.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "CheckIns")
@Builder
public class CheckIn extends BaseModel {
    
    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false) // foreign key column
    private Booking booking;

    private LocalDateTime checkInTime;

    @ManyToOne
    @JoinColumn(name = "entrygate_id", nullable = false) // foreign key column
    private EntryGate entryGate;
}
