package com.manjiri.parkingBookingSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Reciepts")
@Getter
@Setter
public class Reciept extends BaseModel {
    @ManyToOne
    private User user;
    
}
