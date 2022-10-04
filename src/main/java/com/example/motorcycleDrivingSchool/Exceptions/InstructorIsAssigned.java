package com.example.motorcycleDrivingSchool.Exceptions;

public class InstructorIsAssigned extends RuntimeException{

    public InstructorIsAssigned(){
        super("Instructor is assigned");
    }
}
