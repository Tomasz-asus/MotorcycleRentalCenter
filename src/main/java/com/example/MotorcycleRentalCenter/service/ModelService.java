package com.example.MotorcycleRentalCenter.service;


import com.example.MotorcycleRentalCenter.DTO.*;
import com.example.MotorcycleRentalCenter.Exceptions.*;
import com.example.MotorcycleRentalCenter.models.Instructor;
import com.example.MotorcycleRentalCenter.models.InstructorUnavailableDays;
import com.example.MotorcycleRentalCenter.models.Models;
import com.example.MotorcycleRentalCenter.models.Producent;
import com.example.MotorcycleRentalCenter.repository.InstructorRepo;
import com.example.MotorcycleRentalCenter.repository.ModelsRepo;
import com.example.MotorcycleRentalCenter.repository.ProducentRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ModelService {

    private final InstructorRepo instructorRepo;
    private final Mapper mapper;
    private final ModelsRepo modelsRepo;
    private final ProducentRepo producentRepo;
    private final InstructorService instructorService;

    public ModelService(InstructorRepo instructorRepo,
                        Mapper mapper,
                        ModelsRepo modelsRepo,
                        ProducentRepo producentRepo,
                        InstructorService instructorService) {
        this.instructorRepo = instructorRepo;
        this.mapper = mapper;
        this.modelsRepo = modelsRepo;
        this.producentRepo = producentRepo;
        this.instructorService = instructorService;
    }

    public List<ModelsDTO> models() {
        return modelsRepo.findAll()
                .stream()
                .map(mapper::modelsToDTO)
                .collect(Collectors.toList());
    }

    public ModelsDTO addModels(ModelsDTO modelsDTO, String producentName) {

        Producent producent = producentRepo.findProducentByName(producentName)
                .orElseThrow(ProducentNotExist::new);

        isNameOfModelsExist(modelsDTO, producent);
        modelsDTO.assignFrontId(modelsDTO.getName(), producentName);
        Models models = mapper.modelsDTOtoModels(modelsDTO);
        Models saveToRepo = modelsRepo.save(models);
        producent.assignModels(saveToRepo);
        producentRepo.save(producent);

        return mapper.modelsToDTO(saveToRepo);

    }

    public void addInstructorToModels(InstructorAssignmentDTO instructorAssignmentDTO){

        Instructor instructor = instructorRepo.findByName(instructorAssignmentDTO.getInstructorName())
                .orElseThrow(InstructorNotExist::new);
        Models models = modelsRepo.findByName(instructorAssignmentDTO.getModelsName())
                .orElseThrow(ModelsNotExist::new);

        isInstructorAssignmed(instructorAssignmentDTO, models);
        assignInstructor(instructor, models);
        modelsRepo.save(models);
    }

    private void assignInstructor(Instructor instructor, Models models) {
        models.assignInstructor(instructor);
    }

    private void isNameOfModelsExist(ModelsDTO modelsDTO, Producent producent) {
        if (producent.getModels().stream()
                .anyMatch(producents -> producent.getName()
                        .equals(modelsDTO.getName()))) {
            throw new NameAlreadyExist();
        }
    }

    private void isInstructorAssignmed(InstructorAssignmentDTO instructorAssignmentDTO,
                                       Models models) {
        if (models.getInstructor()
                .stream()
                .anyMatch(instructorName -> instructorName.getName()
                        .equals(instructorAssignmentDTO.getInstructorName()))){
            throw new InstructorIsAssigned();
        }
    }

    public void assignUnavailableDaysByDuration(LocalDate trainingStart, double duration, String trainerName) {
        Instructor instructor = instructorRepo.findByName(trainerName).orElseThrow();
        int modelsDays = duration % 8 > 0 ? (int) duration / 8 + 1: (int) duration / 8;
        for (int i = 1; i <= modelsDays; i++){
            InstructorUnavailableDays instructorUnavailableDays = new InstructorUnavailableDays();
            if (i > 1){
                instructorUnavailableDays.setUnavailableDay(trainingStart.plusDays(i - 1));
                instructor.assignUnavailableDays(instructorUnavailableDays);
            } else {
                instructorUnavailableDays.setUnavailableDay(trainingStart);
                instructor.assignUnavailableDays(instructorUnavailableDays);
            }
        }
        instructorRepo.save(instructor);
    }

    public void addModelsPeriod(RentalDTO rentalDTO,
                                  String trainingId) {

        Models models = modelsRepo.findByFrontId(trainingId)
                .orElseThrow(ModelsNotExist::new);

        isRentalExist(rentalDTO, models);
        models.assignRental(mapper.modelsRentalDTOtoModelsRental(rentalDTO));
        modelsRepo.save(models);
    }

    private void isRentalExist(RentalDTO rentalDTO, Models models) {
        if (models.getRental()
                .stream()
                .anyMatch(modelsRential -> modelsRential.getStartRental()
                        .equals(rentalDTO.getStartRental()))){
            throw new RentalPeriodExist();
        }
    }

    public void addRentialAndInstructor(RentalAndInstructorAssignDTO rentalAndInstructorAssignDTO,
                                    String modelsId) {
        addModelsPeriod(rentalAndInstructorAssignDTO.getRentalDTO(), modelsId);
        Models models = modelsRepo.findByFrontId(modelsId).orElseThrow();
        ModelsDTO modelsDTO = mapper.modelsToDTO(models);
        instructorService.addInstructor(rentalAndInstructorAssignDTO.getInstructorDTO());
        instructorService.assignUnavailableDays(rentalAndInstructorAssignDTO.getRentalDTO(),
                rentalAndInstructorAssignDTO.getInstructorDTO().getName());
        InstructorAssignmentDTO instructorAssignmentDTO = new InstructorAssignmentDTO(rentalAndInstructorAssignDTO.
                getInstructorDTO().getName(), modelsDTO.getName());
        addInstructorToModels(instructorAssignmentDTO);
    }
}

