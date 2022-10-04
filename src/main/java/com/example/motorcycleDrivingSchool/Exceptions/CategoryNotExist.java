package com.example.motorcycleDrivingSchool.Exceptions;


public class CategoryNotExist extends RuntimeException {

    public CategoryNotExist() {
        super("Category doesn't exist");
    }

}
