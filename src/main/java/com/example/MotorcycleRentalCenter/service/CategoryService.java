package com.example.MotorcycleRentalCenter.service;


import com.example.MotorcycleRentalCenter.DTO.CategoryDTO;
import com.example.MotorcycleRentalCenter.DTO.Mapper;
import com.example.MotorcycleRentalCenter.DTO.ProducentDTO;
import com.example.MotorcycleRentalCenter.models.Category;
import com.example.MotorcycleRentalCenter.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

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

    public List<CategoryDTO> categoryList(){
        return categoryRepo.findAll().stream()
                .map(mapper::categoryToDTO)
                .collect(toList());
    }

    public List<ProducentDTO> getProducentDTOS(String categoryName) {
        return categoryList().stream()
                .filter(f -> f.getName().equals(categoryName))
                .findFirst()
                .map(CategoryDTO::getList)
                .get();
    }

    public CategoryDTO addCategory(CategoryDTO categoryDTO){
        Category category = mapper.categoryDTOToCategory(categoryDTO);
        Category save = categoryRepo.save(category);
        return mapper.categoryToDTO(save);
    }
}
