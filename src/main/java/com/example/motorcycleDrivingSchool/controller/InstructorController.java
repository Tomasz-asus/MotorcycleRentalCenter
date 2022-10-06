package com.example.motorcycleDrivingSchool.controller;


import com.example.motorcycleDrivingSchool.DTO.InstructorDTO;
import com.example.motorcycleDrivingSchool.DTO.RentalDTO;
import com.example.motorcycleDrivingSchool.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/instructor")
public class InstructorController {

    private final InstructorService instructorService;

    InstructorController(InstructorService instructorService){
        this.instructorService = instructorService;
    }
    @PostMapping
    InstructorDTO addInstructor (@RequestBody InstructorDTO instructorDTO){
        return  instructorService.addInstructor(instructorDTO);
    }
    @GetMapping
    List<InstructorDTO>showInstructor(){
        return instructorService.showAllInstructor();
    }
    @GetMapping("/unavailableDays/{instructorName}")
    List<LocalDate>showInstructorUnavailableDay(@PathVariable String instructorName){
        return instructorService.getUnavailableDays(instructorName);
    }


    @PostMapping("/unavailableDaysAssign/{instructorName}")
    public ResponseEntity<Void>assignUnavailabeDaysToInstructor(@RequestBody RentalDTO rentalDTO,
                                                                @PathVariable String instructorName){
        instructorService.assignUnavailableDays(rentalDTO, instructorName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
