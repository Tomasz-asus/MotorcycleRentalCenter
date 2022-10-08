package com.example.MotorcycleRentalCenter.DTO;

import java.time.LocalDate;

public class RentalDTO {

    private final LocalDate startRental;
    private final LocalDate endRental;

    public RentalDTO (LocalDate startRental, LocalDate endRental) {
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

