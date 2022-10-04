package com.example.motorcycleDrivingSchool.repository;

import com.example.motorcycleDrivingSchool.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);

    Optional<Category> findByImgUrl(String imgUrl);
}
