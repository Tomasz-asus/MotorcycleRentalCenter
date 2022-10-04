package com.example.motorcycleDrivingSchool.Exceptions;

public class InstructorIsNotExist extends RuntimeException{

    public InstructorIsNotExist(){
        super(" Instructor not exist");
    }
}
