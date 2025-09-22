package com.manjiri.parkingBookingSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "EntryGates")
@Getter
@Setter
@Builder
public class EntryGate extends BaseModel {
    private String name;

    @ManyToOne
    @JoinColumn(name = "parking_lot_id", nullable = false) // foreign key column
    private ParkingLot parkingLot;
}
