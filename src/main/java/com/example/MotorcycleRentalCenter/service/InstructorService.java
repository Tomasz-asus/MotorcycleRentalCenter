package com.example.MotorcycleRentalCenter.service;

import com.example.MotorcycleRentalCenter.DTO.InstructorDTO;
import com.example.MotorcycleRentalCenter.DTO.Mapper;
import com.example.MotorcycleRentalCenter.DTO.RentalDTO;
import com.example.MotorcycleRentalCenter.Exceptions.InstructorNotExist;
import com.example.MotorcycleRentalCenter.models.Instructor;
import com.example.MotorcycleRentalCenter.models.InstructorUnavailableDays;
import com.example.MotorcycleRentalCenter.repository.InstructorRepo;
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

    public InstructorDTO addInstructor(InstructorDTO instructorDTO) {
        Instructor instructor = mapper.instructorDTOtoInstructor(instructorDTO);
        Instructor save = instructorRepo.save(instructor);
        return mapper.instructorToDTO(save);
    }

    public List<InstructorDTO> showAllInsstructors() {
        return instructorRepo.findAll().stream()
                .map(mapper::instructorToDTO)
                .toList();
    }

    public List<LocalDate> getUnavailableDays(String name) {
        List<LocalDate> unavailableDays = new ArrayList<>();
        Instructor instructor = instructorRepo.findByName(name).orElseThrow(InstructorNotExist::new);
        instructor.getUnavailableDays().forEach(days -> unavailableDays.add(days.getUnavailableDay()));
        return unavailableDays;
    }

    public void assignUnavailableDays(RentalDTO rentalDTO, String instructorName) {

        Instructor instructor = instructorRepo.findByName(instructorName).orElseThrow(InstructorNotExist::new);
        LocalDate startRepo = rentalDTO.getStartRental();
        LocalDate endRepo = rentalDTO.getEndRental();
        long unavailableDays = ChronoUnit.DAYS.between(startRepo, endRepo) + 1;

        LongStream.rangeClosed(1, unavailableDays)
                .mapToObj(i -> new InstructorUnavailableDays(startRepo.plusDays(i)))
                .forEach(instructor::assignUnavailableDays);

//        This comment left for education compare

//        for (int i = 0; i < unavailableDays; i++){
//            InstructorUnavailableDays instructorUnavailableDays = new InstructorUnavailableDays();
//                instructorUnavailableDays.setUnavailableDay(startRental.plusDays(i));
//                instructor.assignUnavailableDays(instructorUnavailableDays);
//        }

        instructorRepo.save(instructor);
    }
}
