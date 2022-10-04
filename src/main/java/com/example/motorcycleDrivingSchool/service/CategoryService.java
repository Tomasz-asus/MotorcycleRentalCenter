package com.example.motorcycleDrivingSchool.service;


import com.example.motorcycleDrivingSchool.DTO.CategoryDTO;
import com.example.motorcycleDrivingSchool.DTO.Mapper;
import com.example.motorcycleDrivingSchool.DTO.ProducentDTO;
import com.example.motorcycleDrivingSchool.models.Category;
import com.example.motorcycleDrivingSchool.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryService {
     private final Mapper mapper;

     private final CategoryRepo categoryRepo;
@Autowired
    public CategoryService(Mapper mapper, CategoryRepo categoryRepo) {
        this.mapper = mapper;
        this.categoryRepo = categoryRepo;
    }

    public List<ProducentDTO> getProducentDTOS(String categoryName){
    return getProducentDTOS("Sport");
    }
}
