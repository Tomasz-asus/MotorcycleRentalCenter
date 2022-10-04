package com.example.motorcycleDrivingSchool.repository;

import com.example.motorcycleDrivingSchool.models.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepo extends JpaRepository<Rental, Long> {
}
