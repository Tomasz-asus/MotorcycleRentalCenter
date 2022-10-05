package com.example.motorcycleDrivingSchool.Exceptions;

public class InstructorNotExist extends RuntimeException{

    public InstructorNotExist(){
        super(" Instructor not exist");
    }
}
