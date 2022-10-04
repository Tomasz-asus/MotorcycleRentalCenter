package com.example.motorcycleDrivingSchool.Exceptions;

public class RentalPeriodExist extends RuntimeException {
    public RentalPeriodExist(){
        super("Rental period exists");
    }
}
