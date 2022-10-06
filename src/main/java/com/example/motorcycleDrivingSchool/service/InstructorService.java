package com.example.motorcycleDrivingSchool.service;

import com.example.motorcycleDrivingSchool.DTO.InstructorDTO;
import com.example.motorcycleDrivingSchool.DTO.Mapper;
import com.example.motorcycleDrivingSchool.DTO.RentalDTO;
import com.example.motorcycleDrivingSchool.Exceptions.InstructorNotExist;
import com.example.motorcycleDrivingSchool.models.Instructor;
import com.example.motorcycleDrivingSchool.models.InstructorUnavailableDays;
import com.example.motorcycleDrivingSchool.repository.InstructorRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

@Service
@Transactional
public class InstructorService {
    private final Mapper mapper;
    private final InstructorRepo instructorRepo;
    public InstructorService(Mapper mapper, InstructorRepo instructorRepo) {
        this.mapper = mapper;
        this.instructorRepo = instructorRepo;
    }
    public InstructorDTO addInstructor(InstructorDTO instructorDTO){
        Instructor instructor =mapper.instructorDTOToInstructor(instructorDTO);
        Instructor save = instructorRepo.save(instructor);
        return mapper.instructorToDTO(save);
    }
    public void assignUnavailableDays (RentalDTO rentalDTO, String instructorName){
        Instructor instructor = instructorRepo.findByName(instructorName)
                .orElseThrow(InstructorNotExist::new);
        LocalDate startRental = rentalDTO.getStartRental();
        LocalDate endRental = rentalDTO.getEndRental();
        long unavailableDays = ChronoUnit.DAYS.between(startRental,endRental)+1;

        LongStream.rangeClosed(1, unavailableDays)
                .mapToObj(i -> new InstructorUnavailableDays(startRental.plusDays(i)))
                .forEach(instructor::assignUnavailableDays);
        instructorRepo.save(instructor);
    }
    public List<InstructorDTO> showAllInstructor() {
    return instructorRepo.findAll()
            .stream()
            .map(mapper::instructorToDTO)
            .toList();
    }
    public List<LocalDate> getUnavailableDays(String instructorName) {
        List<LocalDate> unavailableDays = new ArrayList<>();
        Instructor instructor = instructorRepo
                .findByName(instructorName)
                .orElseThrow(InstructorNotExist::new);
        instructor.getUnavailableDays()
                .forEach(days->unavailableDays.add(days.getUnavailableDay()));
        return unavailableDays;
    }
}
