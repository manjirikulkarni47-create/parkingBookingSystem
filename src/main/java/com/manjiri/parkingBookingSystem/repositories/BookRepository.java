package com.manjiri.parkingBookingSystem.repositories;

import com.manjiri.parkingBookingSystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
