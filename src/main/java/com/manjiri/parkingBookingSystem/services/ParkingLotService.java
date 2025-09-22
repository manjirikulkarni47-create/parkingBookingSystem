package com.manjiri.parkingBookingSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.manjiri.parkingBookingSystem.dto.EntryGateDTO;
import com.manjiri.parkingBookingSystem.dto.ExitGateDTO;
import com.manjiri.parkingBookingSystem.dto.ParkingFloorDTO;
import com.manjiri.parkingBookingSystem.dto.ParkingLotDTO;
import com.manjiri.parkingBookingSystem.dto.ParkingSpotDTO;
import com.manjiri.parkingBookingSystem.model.EntryGate;
import com.manjiri.parkingBookingSystem.model.ExitGate;
import com.manjiri.parkingBookingSystem.model.ParkingFloor;
import com.manjiri.parkingBookingSystem.model.ParkingLot;
import com.manjiri.parkingBookingSystem.model.ParkingSpot;
import com.manjiri.parkingBookingSystem.model.User;
import com.manjiri.parkingBookingSystem.repositories.EntryGateRepository;
import com.manjiri.parkingBookingSystem.repositories.ExitGateRepository;
import com.manjiri.parkingBookingSystem.repositories.ParkingFloorRepository;
import com.manjiri.parkingBookingSystem.repositories.ParkingLotRepository;
import com.manjiri.parkingBookingSystem.repositories.ParkingSpotRepository;
import com.manjiri.parkingBookingSystem.repositories.UserRepository;

@Service
public class ParkingLotService {


    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    private EntryGateRepository entryGateRepository;

    @Autowired
    private ExitGateRepository exitGateRepository;

    @Autowired
    private ParkingFloorRepository parkingFloorRepository;

    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    @Autowired
    private UserRepository userRepository;

    public Page<ParkingLot> getParkingLots(Long page, Long pageSize) {
        // Get all ParkingLots
        Pageable pageable = Pageable.ofSize(pageSize.intValue()).withPage(page.intValue());
        return parkingLotRepository.findAll(pageable);
    }

    public ParkingLot createParkingLot(ParkingLotDTO parkingLotDTO) {
        // Create and save ParkingLot entity from DTO
        ParkingLot parkingLot = ParkingLot.builder()
            .name(parkingLotDTO.getName())
            .Address(parkingLotDTO.getAddress())
            .Latitude(parkingLotDTO.getLatitude())
            .Longitude(parkingLotDTO.getLongitude())
            .build();
        
        parkingLot = parkingLotRepository.save(parkingLot); // Save to assign ID for relations
        
        // Add Entry Gates
        if (parkingLotDTO.getEntryGates() != null) {
            for (EntryGateDTO entryGateDTO : parkingLotDTO.getEntryGates()) {
                EntryGate entryGate = EntryGate.builder()
                    .name(entryGateDTO.getName())
                    .parkingLot(parkingLot) // Associate with ParkingLot
                    .build();
                entryGateRepository.save(entryGate);
            }
        }
        
        // Add Exit Gates
        if (parkingLotDTO.getExitGates() != null) {
            for (ExitGateDTO exitGateDTO : parkingLotDTO.getExitGates()) {
                ExitGate exitGate = ExitGate.builder()
                    .name(exitGateDTO.getName())
                    .parkingLot(parkingLot) // Associate with ParkingLot
                    .build();
                exitGateRepository.save(exitGate);
            }
        }
        
        // Add Parking Floors
        if (parkingLotDTO.getParkingFloors() != null) {
            for (ParkingFloorDTO parkingFloorDTO : parkingLotDTO.getParkingFloors()) {
                ParkingFloor parkingFloor = ParkingFloor.builder()
                    .floorNumber(parkingFloorDTO.getFloorNumber())
                    .parkingLot(parkingLot) // Associate with ParkingLot
                    .build();
                
                parkingFloor = parkingFloorRepository.save(parkingFloor); // Save to assign ID for spots
                
                // Add Parking Spots for each Floor
                if (parkingFloorDTO.getParkingSpots() != null) {
                    for (ParkingSpotDTO parkingSpotDTO : parkingFloorDTO.getParkingSpots()) {
                        ParkingSpot parkingSpot = ParkingSpot.builder()
                            .spotNumber(parkingSpotDTO.getSpotNumber())
                            .isFree(parkingSpotDTO.getIsFree())
                            .supportedVehicleType(parkingSpotDTO.getSupportedVehicleType())
                            .hasCharger(parkingSpotDTO.getHasCharger())
                            .parkingFloor(parkingFloor) // Associate with ParkingFloor
                            .parkingLot(parkingLot)     // Associate with ParkingLot
                            .build();
                        parkingSpotRepository.save(parkingSpot);
                    }
                }
            }
        }
        
        return parkingLot; // Return the created ParkingLot with associated entities
    }

}
