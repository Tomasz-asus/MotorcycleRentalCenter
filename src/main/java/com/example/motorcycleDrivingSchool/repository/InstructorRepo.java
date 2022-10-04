package com.example.motorcycleDrivingSchool.repository;

import com.example.motorcycleDrivingSchool.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepo extends JpaRepository<Instructor, Long> {
}
