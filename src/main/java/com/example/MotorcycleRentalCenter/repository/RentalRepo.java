package com.example.MotorcycleRentalCenter.repository;

import com.example.MotorcycleRentalCenter.models.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepo extends JpaRepository<Rental, Long> {

}
