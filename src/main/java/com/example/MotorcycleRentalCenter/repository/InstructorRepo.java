package com.example.MotorcycleRentalCenter.repository;

import com.example.MotorcycleRentalCenter.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepo extends JpaRepository <Instructor, Long> {

    Optional<Instructor> findByName(String name);

}
