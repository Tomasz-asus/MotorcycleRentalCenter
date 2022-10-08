package com.example.MotorcycleRentalCenter.Exceptions;

public class RentalPeriodExist extends RuntimeException {
    public RentalPeriodExist(){
        super("Rental period exists");
    }
}
