package com.example.motorcycleDrivingSchool.repository;

import com.example.motorcycleDrivingSchool.models.Category;
import com.example.motorcycleDrivingSchool.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface InstructorRepo extends JpaRepository<Instructor, Long> {

}
