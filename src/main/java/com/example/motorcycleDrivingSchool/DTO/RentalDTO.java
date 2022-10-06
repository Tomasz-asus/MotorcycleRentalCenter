package com.example.motorcycleDrivingSchool.DTO;

import java.time.LocalDate;

public class RentalDTO {
    private LocalDate startRental;

    private LocalDate endRental;

    public RentalDTO(LocalDate of) {
    }

    public RentalDTO(LocalDate startRental, LocalDate endRental) {
        this.startRental = startRental;
        this.endRental = endRental;
    }

    public LocalDate getStartRental() {
        return startRental;
    }

    public LocalDate getEndRental() {
        return endRental;
    }

    @Override
    public String toString() {
        return "RentalDTO{" +
                "startRental=" + startRental +
                ", endRental=" + endRental +
                '}';
    }
}
