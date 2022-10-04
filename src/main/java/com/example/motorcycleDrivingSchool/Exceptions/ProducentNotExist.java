package com.example.motorcycleDrivingSchool.Exceptions;

public class ProducentNotExist extends RuntimeException{

    public ProducentNotExist() {
        super("Producent doesn't exist");
    }
}
