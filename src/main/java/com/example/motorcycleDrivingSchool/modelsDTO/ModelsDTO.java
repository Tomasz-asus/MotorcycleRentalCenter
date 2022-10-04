package com.example.motorcycleDrivingSchool.modelsDTO;

import java.util.List;

public class ModelsDTO {

    private final String name;

    private final String duration;

    private final double price;

    private final String description;

    private final List<RentalDTO> rentalDTO;

    private final List<InstructorDTO> instructorDTOS;

    public ModelsDTO(String name, String duration, double price, String description, List<RentalDTO> rentalDTO, List<InstructorDTO> instructorDTOS) {
        this.name = name;
        this.duration = duration;
        this.price = price;
        this.description = description;
        this.rentalDTO = rentalDTO;
        this.instructorDTOS = instructorDTOS;
    }

    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public List<RentalDTO> getRentalDTO() {
        return rentalDTO;
    }

    public List<InstructorDTO> getInstructorDTOS() {
        return instructorDTOS;
    }

    @Override
    public String toString() {
        return "ModelsDTO{" +
                "name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
