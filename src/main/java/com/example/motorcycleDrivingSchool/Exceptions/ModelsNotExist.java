package com.example.motorcycleDrivingSchool.Exceptions;

public class ModelsNotExist extends RuntimeException {

    public ModelsNotExist(){
        super("Models doesn't exists");
    }
}
