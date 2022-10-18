package com.example.MotorcycleRentalCenter.service;

import com.example.MotorcycleRentalCenter.models.Instructor;
import com.example.MotorcycleRentalCenter.models.Rental;
import com.example.MotorcycleRentalCenter.models.Models;
import com.example.MotorcycleRentalCenter.repository.InstructorRepo;
import com.example.MotorcycleRentalCenter.repository.InstructorUnavailableDaysRepo;
import com.example.MotorcycleRentalCenter.repository.RentalRepo;
import com.example.MotorcycleRentalCenter.repository.ModelsRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class ModelsServiceTest {
    @Autowired
    ModelsRepo modelsRepo;
    @Autowired
    InstructorRepo instructorRepo;
    @Autowired
    InstructorUnavailableDaysRepo instructorUnavailableDaysRepo;
    @Autowired
    ModelService modelService;
    @Autowired
    InstructorService instructorService;
    @Autowired
    RentalRepo rentalRepo;

    @BeforeEach
    public void setup(){
        modelsRepo.deleteAll();
    }

    @Test
    public void showUnavailableDaysInstructor(){
        //given
        Models basicYamaha = getModels();
        Instructor instructor = getInstructor();
        instructorRepo.save(instructor);
        basicYamaha.assignInstructor(instructor);
        modelsRepo.save(basicYamaha);
        //when
        modelService.assignUnavailableDaysByDuration(LocalDate.parse("2022-10-01"), basicYamaha.getDuration(), instructor.getName());
        List<LocalDate> unavailableDays = instructorService.getUnavailableDays(instructor.getName());
        //then
        assertThat(unavailableDays.get(0)).isEqualTo("2022-10-01");

    }

    @Test
    public void date(){
        //given
        Rental rental = new Rental(LocalDate.parse("2022-09-20"), LocalDate.parse("2022-09-22"));
        Instructor instructor = getInstructor();
        instructorRepo.save(instructor);

    }

    private Instructor getInstructor() {
        return new Instructor("Tomi", "Lorem");
    }

    private Models getModels() {
        return new Models("BasicYamaha", 3.00,  2.0, "Lorem Ipsum", "BasicYamaha");
    }
}
