package com.example.motorcycleDrivingSchool.Exceptions;

public class NameAlreadyExist extends RuntimeException {
    public NameAlreadyExist() {
        super("Name already exist");
    }
}
