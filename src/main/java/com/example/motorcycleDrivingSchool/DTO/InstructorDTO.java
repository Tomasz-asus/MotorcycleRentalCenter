package com.example.motorcycleDrivingSchool.DTO;

import java.time.LocalDate;
import java.util.List;

public class InstructorDTO {

    private final String Name;
    private final int Age;
    private final List<LocalDate> unavailableDays;


    public InstructorDTO(String name, int age, List<LocalDate> unavailableDays) {
        Name = name;
        Age = age;
        this.unavailableDays = unavailableDays;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }

    public List<LocalDate> getUnavailableDays() {
        return unavailableDays;
    }
}
