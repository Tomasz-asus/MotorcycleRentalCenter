package com.example.motorcycleDrivingSchool.repository;

import com.example.motorcycleDrivingSchool.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}