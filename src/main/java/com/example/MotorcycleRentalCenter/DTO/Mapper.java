package com.example.MotorcycleRentalCenter.DTO;


import com.example.MotorcycleRentalCenter.models.*;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class Mapper {

    public CategoryDTO categoryToDTO(Category category){
        String name = category.getName();
        String descriptions = category.getDescription();
        String imgUrl = category.getImgUrl();
        List<ProducentDTO> list = category.getShopsCategories()
                .stream()
                .map(this::producentToDTO)
                .collect(Collectors.toList());
        return new CategoryDTO(name, descriptions, imgUrl, list);
    }
    public Category categoryDTOToCategory(CategoryDTO categoryDTO){
        return new Category(categoryDTO.getName(), categoryDTO.getDescription(), categoryDTO.getImgUrl(), categoryDTO.getList()
                .stream()
                .map(this::producentDTOtoProducent)
                .collect(Collectors.toList()));
    }

    public ProducentDTO producentToDTO(Producent producent){
        String name = producent.getName();
        List<ModelsDTO> models = producent.getModels()
                .stream()
                .map(this::modelsToDTO)
                .collect(Collectors.toList());
        return new ProducentDTO(name, models);
    }

    public Producent producentDTOtoProducent(ProducentDTO producentDTO){
        return new Producent(producentDTO.getName(), producentDTO.getModels()
                .stream()
                .map(this::modelsDTOtoModels)
                .collect(Collectors.toList()));
    }


    public ModelsDTO modelsToDTO(Models models){
        String name = models.getName();
        double price = models.getPrice();
        double duration = models.getDuration();
        String description = models.getDescription();
        String front_Id = models.getFrontId();
        List<InstructorDTO> instructors = models.getInstructor()
                .stream()
                .map(this::instructorToDTO)
                .collect(Collectors.toList());
        List<RentalDTO> modelsRental = models.getRental()
                .stream()
                .map(this::trainingPeriodToDTO)
                .toList();
        return new ModelsDTO(name, price, duration, description, front_Id, instructors, modelsRental);
    }
    public Models modelsDTOtoModels(ModelsDTO modelsDTO){
        return new Models(modelsDTO.getName(),
                modelsDTO.getPrice(),
                modelsDTO.getDuration(),
                modelsDTO.getDescription(),
                modelsDTO.getFrontId(),
                modelsDTO.getInstructors()
                        .stream()
                        .map(this::instructorDTOtoInstructor)
                        .toList(),
                modelsDTO.getRentalDTOS()
                        .stream()
                        .map(this::modelsRentalDTOtoModelsRental)
                        .toList());
    }

    public InstructorDTO instructorToDTO(Instructor instructor){
        String name = instructor.getName();
        String bio = instructor.getBio();
        List<LocalDate> unavailableDays = instructor.getUnavailableDays().stream()
                .map(InstructorUnavailableDays::getUnavailableDay)
                .toList();
        return new InstructorDTO(name, bio, unavailableDays);
    }

    public Instructor instructorDTOtoInstructor(InstructorDTO instructorDTO){
        return new Instructor(instructorDTO.getName(), instructorDTO.getBio());
    }

    public RentalDTO trainingPeriodToDTO(Rental rental){
        LocalDate startRental = rental.getStartRental();
        LocalDate endRental = rental.getEndRental();
        return new RentalDTO(startRental, endRental);
    }

    public Rental modelsRentalDTOtoModelsRental(RentalDTO rentalDTO){
        return new Rental(rentalDTO.getStartRental(),
                (rentalDTO.getEndRental()));
    }

}

