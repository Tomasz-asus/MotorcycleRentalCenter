package com.example.MotorcycleRentalCenter.Exceptions;

public class NameAlreadyExist extends RuntimeException {
    public NameAlreadyExist() {
        super("Name already exist");
    }
}
