package com.example.MotorcycleRentalCenter.Exceptions;

public class ModelsNotExist extends RuntimeException {

    public ModelsNotExist(){
        super("Models doesn't exists");
    }
}
