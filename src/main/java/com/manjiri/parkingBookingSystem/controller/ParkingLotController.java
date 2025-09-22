package com.manjiri.parkingBookingSystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.manjiri.parkingBookingSystem.dto.ParkingLotDTO;
import com.manjiri.parkingBookingSystem.model.ParkingLot;
import com.manjiri.parkingBookingSystem.services.ParkingLotService;


@RestController
@RequestMapping("/api/parkinglot")
public class ParkingLotController {
    
    @Autowired
    private ParkingLotService parkingLotService;

    @PostMapping("/create")
    public  ResponseEntity<ParkingLot> createParkingLot(@RequestBody ParkingLotDTO parkingLotDTO ) {
        try {


            ParkingLot savedParkingLot = parkingLotService.createParkingLot(parkingLotDTO);

            return new ResponseEntity<>(savedParkingLot, HttpStatus.CREATED);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // TODO : api to edit parking lot details
    // TODO : api to delete parking lot, or desable it
    // TODO : api to get parking lot details

    // Get all parking spots or specific parking lot details
    @GetMapping("/")
    public ResponseEntity<Page<ParkingLot>> getParkingLots(
        @RequestParam(name = "page", defaultValue = "1") Long page,
        @RequestParam(name = "pageSize", defaultValue = "10") Long pageSize
    ) {
        try {
            return new ResponseEntity<>(parkingLotService.getParkingLots(page, pageSize), HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
