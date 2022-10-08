package com.example.MotorcycleRentalCenter.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class InstructorDTO {

    private String name;
    private String bio;
    private List<LocalDate> unavailableDays = new ArrayList<>();

    public InstructorDTO() {
    }

    public InstructorDTO(String name, String bio){
        this.name=name;
        this.bio=bio;
    }

    public InstructorDTO(String name, String bio, List<LocalDate> unavailableDays) {
        this.name = name;
        this.bio = bio;
        this.unavailableDays = unavailableDays;
    }

    public String getName(){ return name;}

    public String getBio(){ return bio;}

    public List<LocalDate> getUnavailableDays() {
        return unavailableDays;
    }

    public void assignUnavailableDays(List<LocalDate> unavailableDays) {
        this.unavailableDays = unavailableDays;
    }
}
