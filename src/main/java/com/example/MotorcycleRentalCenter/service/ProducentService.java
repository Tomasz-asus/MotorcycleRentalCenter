package com.example.MotorcycleRentalCenter.service;

import com.example.MotorcycleRentalCenter.DTO.Mapper;
import com.example.MotorcycleRentalCenter.DTO.ModelsDTO;
import com.example.MotorcycleRentalCenter.DTO.ProducentDTO;
import com.example.MotorcycleRentalCenter.Exceptions.CategoryNotExist;
import com.example.MotorcycleRentalCenter.Exceptions.NameAlreadyExist;
import com.example.MotorcycleRentalCenter.models.Category;
import com.example.MotorcycleRentalCenter.models.Models;
import com.example.MotorcycleRentalCenter.models.Producent;
import com.example.MotorcycleRentalCenter.repository.CategoryRepo;
import com.example.MotorcycleRentalCenter.repository.ProducentRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProducentService {

    private final Mapper mapper;
    private final ProducentRepo producentRepo;
    private final CategoryRepo categoryRepo;

    public ProducentService(Mapper mapper, ProducentRepo producentRepo, CategoryRepo categoryRepo) {
        this.mapper = mapper;
        this.producentRepo = producentRepo;
        this.categoryRepo = categoryRepo;
    }

    public List<ProducentDTO> categoryProducentList(){
        return producentRepo.findAll().stream()
                .map(mapper::producentToDTO)
                .collect(Collectors.toList());
    }

    public List<ModelsDTO> getModelsDTOS(String producentName, String categoryName) {
        List<Models> modelsList = categoryRepo
                .findByName(categoryName)
                .map(Category::getShopsCategories)
                .flatMap(producent -> producent.stream()
                        .filter(f -> f.getName().equals(categoryName))
                        .findFirst())
                .map(Producent::getModels)
                .orElse(Collections.emptyList());
        return modelsList.stream()
                .map(mapper::modelsToDTO)
                .toList();

    }

    public ProducentDTO addCategoryProducent(ProducentDTO producentDTO, String categoryName){

        if (categoryRepo.findByName(categoryName).isEmpty()){
            throw new CategoryNotExist();
        }
        Category category = categoryRepo.findByName(categoryName).orElseThrow();
        if (category.getShopsCategories().stream()
                .anyMatch(producent -> producent.getName()
                        .equalsIgnoreCase(producentDTO.getName()))){
            throw new NameAlreadyExist();
        }
        Producent save1 = producentRepo.save(mapper.producentDTOtoProducent(producentDTO));
        category.getShopsCategories().add(save1);
        categoryRepo.save(category);

        return mapper.producentToDTO(save1);
    }



}
