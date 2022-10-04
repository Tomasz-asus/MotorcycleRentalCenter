package com.example.motorcycleDrivingSchool.repository;

import com.example.motorcycleDrivingSchool.models.Category;
import com.example.motorcycleDrivingSchool.models.Models;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Long> {
  //  List<Models> findByName(String categoryName);

    Optional<Category> findByName(String name);

    Optional<Category> findByImgUrl(String imgUrl);
}
