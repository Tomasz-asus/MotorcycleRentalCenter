package com.example.motorcycleDrivingSchool.modelsDTO;

import com.example.motorcycleDrivingSchool.models.InstructorUnavailableDays;

import java.util.ArrayList;
import java.util.List;

public class InstructorDTO {

    private String Name;
    private int Age;
    private List<InstructorUnavailableDays> unavailableDays = new ArrayList<>();

    public InstructorDTO() {
    }

    public InstructorDTO(String name, int age, List<InstructorUnavailableDays> unavailableDays) {
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

    public List<InstructorUnavailableDays> getUnavailableDays() {
        return unavailableDays;
    }
}
