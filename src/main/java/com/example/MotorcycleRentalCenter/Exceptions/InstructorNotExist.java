package com.example.MotorcycleRentalCenter.Exceptions;

public class InstructorNotExist extends RuntimeException{

    public InstructorNotExist(){
        super(" Instructor is not exist");
    }
}
