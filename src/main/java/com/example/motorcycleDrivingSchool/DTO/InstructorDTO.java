package com.example.motorcycleDrivingSchool.DTO;

import java.time.LocalDate;
import java.util.List;

public class InstructorDTO {

    private  String name;

    private  List<LocalDate> unavailableDays;


    public InstructorDTO(String name) {
        this.name = name;
        this.unavailableDays = unavailableDays;
    }


    public String getName() {
        return name;
    }

    public List<LocalDate> getUnavailableDays() {
        return unavailableDays;
    }
}
