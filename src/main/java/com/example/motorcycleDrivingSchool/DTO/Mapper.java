package com.example.motorcycleDrivingSchool.DTO;


import com.example.motorcycleDrivingSchool.models.*;
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
        List <ProducentDTO> list = category.getCategoryProducent()
                .stream()
                .map(this::producentToDTO)
                .collect(Collectors.toList());
        return new CategoryDTO(name,descriptions,imgUrl, list);
    }

    public Category categoryDTOToCategory(CategoryDTO categoryDTO){
        return new Category(categoryDTO.getName(),
                categoryDTO.getDescription(),
                categoryDTO.getImgUrl(),
                categoryDTO.getList()
                        .stream()
                        .map(this::producentDTOToProducent)
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
    public Producent producentDTOToProducent(ProducentDTO producentDTO){
        return new Producent(producentDTO.getName(), producentDTO.getModelsDTOS()
                .stream()
                .map(this::modelsDTOToModels)
                .collect(Collectors.toList()));
    }


    public ModelsDTO modelsToDTO(Models models){
        String name = models.getName();
        double price = models.getPrice();
        String duration = models.getDuration();
        String description = models.getDescription();
        String frontId = models.getFrontId();
        List<InstructorDTO> instructor = models.getInstructor()
                .stream()
                .map(this::instructorToDTO)
                .collect(Collectors.toList());
        List<RentalDTO> rental = models.getModelsRental()
                .stream()
                .map(this::modelsRentalToDTO)
                .toList();
        return new ModelsDTO(name,duration, price,description, frontId, rental, instructor);
        }

        public Models modelsDTOToModels(ModelsDTO modelsDTO){
        return new Models(modelsDTO.getName(),
                modelsDTO.getDuration(),
                modelsDTO.getPrice(),
                modelsDTO.getDescription(),
                modelsDTO.getFrontId(),
                modelsDTO.getInstructorDTOS()
                        .stream()
                        .map(this::instructorDTOToInstructor)
                        .toList(),
                modelsDTO.getRentalDTO()
                        .stream()
                        .map(this::modelsRentalDTOToModelsRental)
                        .toList());
    }

    public InstructorDTO instructorToDTO( Instructor instructor){
        String name = instructor.getName();
        List<LocalDate> unavailableDays = instructor.getUnavailableDays().stream()
                .map(InstructorUnavailableDays::getUnavailableDay)
                .toList();
        return new InstructorDTO(name);
    }
    public Instructor instructorDTOToInstructor(InstructorDTO instructorDTO){
        return new Instructor(instructorDTO.getName());
    }
    public RentalDTO modelsRentalToDTO(Rental rental ){
        LocalDate startRental = rental.getStartRental();
        LocalDate endRental = rental.getEndRental();
        return new RentalDTO(startRental,endRental);
    }
    public Rental modelsRentalDTOToModelsRental(RentalDTO rentalDTO){
        return new Rental(rentalDTO.getStartRental(),
                rentalDTO.getEndRental());
    }
}



