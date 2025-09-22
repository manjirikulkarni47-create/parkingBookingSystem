package com.manjiri.parkingBookingSystem.services;

import java.util.ArrayList;
import java.util.Optional;

import com.manjiri.parkingBookingSystem.model.Person;
import com.manjiri.parkingBookingSystem.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.manjiri.parkingBookingSystem.dto.RegisterDTO;
import com.manjiri.parkingBookingSystem.model.User;
import com.manjiri.parkingBookingSystem.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService{

    @Autowired 
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PersonRepository personRepository;

    public User registerUser( RegisterDTO registerDTO) {
        if (userRepository.existsByEmail(registerDTO.getEmail())) {
            throw new IllegalArgumentException("Email is already in use.");
        }
        if (userRepository.existsByMobileNumber(registerDTO.getMobileNumber())) {
            throw new IllegalArgumentException("Mobile Number is already in use.");
        }

        String hashedPassword = passwordEncoder.encode(registerDTO.getPassword());

        User user = User.builder()
        .email(registerDTO.getEmail())
        .password(hashedPassword)
        .firstName(registerDTO.getFirstName())
        .lastName(registerDTO.getLastName())
        .userRole(registerDTO.getUserRole())
        .mobileNumber(registerDTO.getMobileNumber())
        .countryCode(registerDTO.getCountryCode())
        .build();
        return userRepository.save(user);
    }

    public Person login(String name, String password) {
        Optional<Person> user = personRepository.findByUsername(name);
        System.out.println("User: " + user);
        if (user == null) {
            throw new IllegalArgumentException("User not found.");
        }
        
        // Compare hashed password
        if (!passwordEncoder.matches(password, user.get().getPasswordHash())) {
            throw new IllegalArgumentException("Invalid password.");
        }
        
        return user.get();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username); // Or find by any field, e.g., username
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), 
                user.getPassword(), 
                new ArrayList<>()); // Or add authorities/roles
    }
}
