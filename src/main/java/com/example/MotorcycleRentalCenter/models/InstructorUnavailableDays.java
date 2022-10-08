package com.example.MotorcycleRentalCenter.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class InstructorUnavailableDays {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate unavailableDay;

    public InstructorUnavailableDays(LocalDate unavailableDay) {
        this.unavailableDay = unavailableDay;
    }

    public InstructorUnavailableDays() {
    }

    public LocalDate getUnavailableDay() {
        return unavailableDay;
    }

    public void setUnavailableDay(LocalDate unavailableDay) {
        this.unavailableDay = unavailableDay;
    }
}
