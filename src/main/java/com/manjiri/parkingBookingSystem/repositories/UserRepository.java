package com.manjiri.parkingBookingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjiri.parkingBookingSystem.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    public boolean existsByEmail(String email);

    public boolean existsByMobileNumber(String mobileNumber);

    public User findByEmail(String email);
}
