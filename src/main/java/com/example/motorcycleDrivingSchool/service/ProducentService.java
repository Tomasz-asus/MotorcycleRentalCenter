package com.example.motorcycleDrivingSchool.service;

import com.example.motorcycleDrivingSchool.DTO.Mapper;
import com.example.motorcycleDrivingSchool.DTO.ModelsDTO;
import com.example.motorcycleDrivingSchool.DTO.ProducentDTO;
import com.example.motorcycleDrivingSchool.models.Category;
import com.example.motorcycleDrivingSchool.models.Models;
import com.example.motorcycleDrivingSchool.repository.CategoryRepo;
import com.example.motorcycleDrivingSchool.repository.ModelsRepo;
import com.example.motorcycleDrivingSchool.repository.ProducentRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProducentService {

    private final Mapper mapper;

    private final CategoryRepo categoryRepo;

    private final ModelsRepo modelsRepo;

    private final ProducentRepo producentRepo;

    public ProducentService(Mapper mapper,
                            CategoryRepo categoryRepo,
                            ModelsRepo modelsRepo,
                            ProducentRepo producentRepo) {
        this.mapper = mapper;
        this.categoryRepo = categoryRepo;
        this.modelsRepo = modelsRepo;
        this.producentRepo = producentRepo;
    }

    public List<ProducentDTO> producentList(){
        return producentRepo.findAll()
                .stream()
                .map(mapper::producentToDTO)
                .collect(Collectors.toList());
    }

}
