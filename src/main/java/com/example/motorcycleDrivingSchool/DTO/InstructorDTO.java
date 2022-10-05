package com.example.motorcycleDrivingSchool.DTO;

import java.time.LocalDate;
import java.util.List;

public class InstructorDTO {

    private final String name;
    private final int Age;
    private final List<LocalDate> unavailableDays;


    public InstructorDTO(String name, int age, List<LocalDate> unavailableDays) {
        this.name = name;
        Age = age;
        this.unavailableDays = unavailableDays;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return Age;
    }

    public List<LocalDate> getUnavailableDays() {
        return unavailableDays;
    }
}
