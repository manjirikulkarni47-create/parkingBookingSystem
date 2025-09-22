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
@Entity(name = "CheckOuts")
@Builder
public class CheckOut extends BaseModel {
    
    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false) // foreign key column
    private Booking booking;

    private LocalDateTime checkOutTime;

    @ManyToOne
    @JoinColumn(name = "exitgate_id", nullable = false) // foreign key column
    private ExitGate exitGate;
}
