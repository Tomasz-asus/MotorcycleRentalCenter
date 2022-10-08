package com.example.MotorcycleRentalCenter.repository;

import com.example.MotorcycleRentalCenter.models.Producent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface ProducentRepo extends JpaRepository<Producent, Long> {

    Optional<Producent> findProducentByName(String name);
}
