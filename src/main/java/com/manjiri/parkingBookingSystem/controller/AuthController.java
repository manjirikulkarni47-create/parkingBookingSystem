package com.manjiri.parkingBookingSystem.controller;

import com.manjiri.parkingBookingSystem.dto.PersonInput;
import com.manjiri.parkingBookingSystem.model.Person;
import com.manjiri.parkingBookingSystem.model.UserRole;
import com.manjiri.parkingBookingSystem.repositories.PersonRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.manjiri.parkingBookingSystem.dto.LoginDTO;
import com.manjiri.parkingBookingSystem.dto.RegisterDTO;
import com.manjiri.parkingBookingSystem.services.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping(path = "/add/user")
    @ResponseStatus(HttpStatus.CREATED)
    @SecurityRequirement(name = "BasicAuth")
    private Person createUser(@RequestBody PersonInput personInput) {
        String hashedPassword = passwordEncoder.encode(personInput.getPassword());
        Person newPerson = new Person(personInput.getUsername(), hashedPassword, UserRole.RENTER);

        return personRepository.save(newPerson);
    }

    @PostMapping(path = "/add/admin")
    @ResponseStatus(HttpStatus.CREATED)
    @SecurityRequirement(name = "BasicAuth")
    private Person createAdmin(@RequestBody PersonInput personInput) {
        String hashedPassword = passwordEncoder.encode(personInput.getPassword());
        Person newPerson = new Person(personInput.getUsername(), hashedPassword, UserRole.ADMIN);

        return personRepository.save(newPerson);
    }

    @PostMapping("/login")
    public ResponseEntity<Void> loginUser(@RequestBody PersonInput personInput, HttpServletResponse response) {
        try {
            userService.login(personInput.getUsername(), personInput.getPassword());
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logoutUser(HttpServletRequest request, HttpServletResponse response) {
        try {
             return new ResponseEntity<>("Logged out successfully.", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("An error occurred while logging out.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
