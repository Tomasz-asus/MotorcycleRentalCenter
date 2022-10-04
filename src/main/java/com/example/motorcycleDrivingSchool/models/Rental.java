package com.example.motorcycleDrivingSchool.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Rental {
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate startRental;

    private LocalDate endRental;

    public Rental() {
    }

    public Rental(LocalDate startRental, LocalDate endRental) {
        this.startRental = startRental;
        this.endRental = endRental;
    }

    public LocalDate getStartRental() {
        return startRental;
    }

    public LocalDate getEndRental() {
        return endRental;
    }


}
