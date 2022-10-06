package com.example.motorcycleDrivingSchool.repository;

import com.example.motorcycleDrivingSchool.models.Producent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface ProducentRepo extends JpaRepository<Producent, Long> {

    Optional<Producent> findByName(String name);


}
