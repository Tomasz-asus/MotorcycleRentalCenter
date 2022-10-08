package com.example.MotorcycleRentalCenter.Exceptions;


public class CategoryNotExist extends RuntimeException {

    public CategoryNotExist() {
        super("Category doesn't exist");
    }

}
