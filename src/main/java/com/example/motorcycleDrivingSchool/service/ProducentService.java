package com.example.motorcycleDrivingSchool.service;

import com.example.motorcycleDrivingSchool.DTO.Mapper;
import com.example.motorcycleDrivingSchool.DTO.ModelsDTO;
import com.example.motorcycleDrivingSchool.DTO.ProducentDTO;
import com.example.motorcycleDrivingSchool.Exceptions.CategoryNotExist;
import com.example.motorcycleDrivingSchool.Exceptions.NameAlreadyExist;
import com.example.motorcycleDrivingSchool.models.Category;
import com.example.motorcycleDrivingSchool.models.Models;
import com.example.motorcycleDrivingSchool.models.Producent;
import com.example.motorcycleDrivingSchool.repository.CategoryRepo;
import com.example.motorcycleDrivingSchool.repository.ModelsRepo;
import com.example.motorcycleDrivingSchool.repository.ProducentRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProducentService {
    private final Mapper mapper;
    private final CategoryRepo categoryRepo;
    private final ProducentRepo producentRepo;
    private final ModelsRepo modelsRepo;
    public ProducentService(Mapper mapper,
                            CategoryRepo categoryRepo,
                            ProducentRepo producentRepo,
                            ModelsRepo modelsRepo){
        this.mapper = mapper;
        this.categoryRepo = categoryRepo;
        this.producentRepo = producentRepo;
        this.modelsRepo = modelsRepo;
    }
    public List<ProducentDTO> producentList(){
        return producentRepo.findAll().stream()
                .map(mapper::producentToDTO)
                .collect(Collectors.toList());
    }
    public List<ModelsDTO> getModelsDTOS(String producentName,
                                     String categoryName){
        List<Models> modelsList = categoryRepo
                .findByName(categoryName)
                .map(Category::getCategoryProducent)
                .flatMap(producent->producent
                        .stream()
                        .filter(f->f.getName().equals(producentName))
                        .findFirst())
                .map(Producent::getModels)
                .orElse(Collections.emptyList());
        return modelsList.stream()
                .map(mapper::modelsToDTO)
                .toList();
}
public ProducentDTO addCategory(ProducentDTO producentDTO, String categoryName){
        if (categoryRepo.findByName(categoryName).isEmpty()){
            throw new CategoryNotExist();
    }
        Category category = categoryRepo.findByName(categoryName).orElseThrow();
        if (category.getCategoryProducent().stream()
                .anyMatch(producent -> producent.getName()
                        .equalsIgnoreCase(producentDTO.getName()))){
            throw new NameAlreadyExist();
        }
        Producent save1 = producentRepo
                .save(mapper.producentDTOToProducent(producentDTO));
        categoryRepo.save(category);
        return mapper.producentToDTO(save1);
}
}
