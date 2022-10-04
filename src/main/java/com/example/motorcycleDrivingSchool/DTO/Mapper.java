package com.example.motorcycleDrivingSchool.DTO;


import com.example.motorcycleDrivingSchool.models.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class Mapper {
public ProducentDTO producentToDTO(Producent producent){
    String name = producent.getName();
    String description = producent.getDescription();
    String imgUrl = producent.getImgUrl();
    List<CategoryDTO> categoryDTOList = producent.getProducentCategory()
            .stream()
            .map(this::categoryToCategoryDTO)
            .collect(Collectors.toList());
    return new ProducentDTO(name,description,imgUrl,categoryDTOList);
}

public Producent producentDTOToProducent(ProducentDTO producentDTO){
    return new Producent(producentDTO.getName(),
            producentDTO.getDescription(),
            producentDTO.getImgUrl(),
            producentDTO.getProducentCategory()
                    .stream()
                    .map(this::categoryDTOToCategory)
                    .collect(Collectors.toList()));
}
public CategoryDTO categoryToCategoryDTO (Category category){
    String name = category.getName();
    List<ModelsDTO> modelsDTOList = category.getCategoryModels()
            .stream()
            .map(this::modelsToDTO)
            .collect(Collectors.toList());
    return new CategoryDTO(name, modelsDTOList);
}

public Category categoryDTOToCategory (CategoryDTO categoryDTO){
    return new Category(categoryDTO.getName(),
            categoryDTO.getModelsDTOS()
                    .stream()
                    .map(this::modelsDTOToModels)
                    .collect(Collectors.toList()));
}

public ModelsDTO modelsToDTO(Models models){
    String name = models.getName();
    String duration = models.getDuration();
    double price = models.getPrice();
    String description = models.getDescription();
    List<InstructorDTO> instructorDTOS = models.getInstructor()
            .stream()
            .map(this::instructorToDTO)
            .collect(Collectors.toList());
    List<RentalDTO> rentalDTO = models.getModelsRental()
            .stream()
            .map(this::rentalToDTO)
            .collect(Collectors.toList());
    return new ModelsDTO(name,duration,price,description, rentalDTO, instructorDTOS);
    }

    public Models modelsDTOToModels (ModelsDTO modelsDTO){
    return new Models(modelsDTO.getName(),
                modelsDTO.getDuration(),
                modelsDTO.getPrice(),
                modelsDTO.getDescription(),
            modelsDTO.getRentalDTO()
                        .stream()
                        .map(this::rentalDTOToRental)
                        .toList(),
            modelsDTO.getInstructorDTOS()
                        .stream()
                        .map(this::instructorDTOS)
                        .toList());
    }

    public InstructorDTO instructorToDTO(Instructor instructor){
    String name = instructor.getName();
    int age = instructor.getAge();
    List<LocalDate> unavailableDays = instructor.getUnavailableDays()
            .stream()
            .map(InstructorUnavailableDays::getUnavailableDay)
            .collect(Collectors.toList());
    return new InstructorDTO(name,age,unavailableDays);
    }

    public Instructor instructorDTOS (InstructorDTO instructorDTO){
    return new Instructor(instructorDTO.getName(),
            instructorDTO.getAge());
    }

    public RentalDTO rentalToDTO(Rental rental){
    LocalDate startRental = rental.getStartRental();
    LocalDate endRental = rental.getEndRental();
    return new RentalDTO(startRental,endRental);
    }

    public Rental rentalDTOToRental(RentalDTO rentalDTO){
    return new Rental(rentalDTO.getStartRental(),
            rentalDTO.getEndRental());
    }

}


