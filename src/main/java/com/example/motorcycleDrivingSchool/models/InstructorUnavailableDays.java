package com.example.motorcycleDrivingSchool.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class InstructorUnavailableDays {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate unavailableDay;
    public InstructorUnavailableDays() {
    }
    public InstructorUnavailableDays(LocalDate unavailableDay) {
        this.unavailableDay = unavailableDay;
    }
    public LocalDate getUnavailableDay() {
        return unavailableDay;
    }
    public void setUnavailableDay(LocalDate unavailableDay) {
        this.unavailableDay = unavailableDay;
    }
}
