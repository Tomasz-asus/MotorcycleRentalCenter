package com.example.MotorcycleRentalCenter.repository;

import com.example.MotorcycleRentalCenter.models.Models;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface ModelsRepo extends JpaRepository<Models, Long> {

    Optional<Models> findByName(String name);
    Optional<Models> findByFrontId(String id);
}
