package com.example.motorcycleDrivingSchool.repository;

import com.example.motorcycleDrivingSchool.models.Models;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface ModelsRepo extends JpaRepository<Models, Long> {
    Optional<Object> findByFrontId(String instructorId);

}
