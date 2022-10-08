package com.example.MotorcycleRentalCenter.Exceptions;

public class InstructorIsAssigned extends RuntimeException{

    public InstructorIsAssigned(){
        super("Instructor is assigned");
    }
}
