package com.example.motorcycleDrivingSchool.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InstructorDTO {

    private  String name;
    private  List<LocalDate> unavailableDays = new ArrayList<>();
    public InstructorDTO(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public List<LocalDate> getUnavailableDays() {
        return unavailableDays;
    }
    public void assignUnavailableDays(List<LocalDate> unavailableDays){
        this.unavailableDays=unavailableDays;
    }
}
