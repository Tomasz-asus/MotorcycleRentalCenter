package com.example.MotorcycleRentalCenter.controller;


import com.example.MotorcycleRentalCenter.DTO.InstructorDTO;
import com.example.MotorcycleRentalCenter.DTO.RentalDTO;
import com.example.MotorcycleRentalCenter.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/instructors")
class InstructorController {
    private final InstructorService instructorService;
    InstructorController(InstructorService instructorsService) {
        this.instructorService = instructorsService;
    }

    @PostMapping
    InstructorDTO addInstructor(@RequestBody InstructorDTO instructorDTO) {
        return instructorService.addInstructor(instructorDTO);
    }

    @GetMapping
    List<InstructorDTO> showInstructors() {
        return instructorService.showAllInsstructors();
    }

    @GetMapping("/unavailableDays/{instructorsName}")
    List<LocalDate> showInstructorsUnavailableDay(@PathVariable String instructorsName){
        return instructorService.getUnavailableDays(instructorsName);
    }

    @PostMapping("/unavailableDaysAssign/{instructorsName}")
    public ResponseEntity<Void> assignUnavailableDaysToInstructor(@RequestBody RentalDTO rentalDTO,
                                                               @PathVariable String instructorsName){
        instructorService.assignUnavailableDays(rentalDTO, instructorsName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
