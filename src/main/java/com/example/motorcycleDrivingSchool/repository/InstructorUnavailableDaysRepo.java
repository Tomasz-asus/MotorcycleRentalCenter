package com.example.motorcycleDrivingSchool.repository;

import com.example.motorcycleDrivingSchool.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorUnavailableDaysRepo extends JpaRepository<Instructor, Long> {
}
