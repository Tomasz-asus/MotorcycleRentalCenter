package com.example.MotorcycleRentalCenter.Exceptions;

public class ProducentNotExist extends RuntimeException{

    public ProducentNotExist() {
        super("Producent doesn't exist");
    }
}
