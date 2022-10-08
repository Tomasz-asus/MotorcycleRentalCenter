package com.example.MotorcycleRentalCenter.DTO;

import java.util.Collections;
import java.util.List;

public class ModelsDTO {

    private final String name;
    private final double price;
    private final double duration;
    private final String description;
    private String frontId;
    private final List<InstructorDTO> instructors;

    private final List<RentalDTO> rentalDTOS;

    public ModelsDTO (String name, double price,
                             double duration,
                             String description,
                             String frontId,
                             List<InstructorDTO> instructors,
                             List<RentalDTO> rentalDTOS) {
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.description = description;
        this.frontId = frontId;
        this.instructors = instructors;
        this.rentalDTOS = rentalDTOS;

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public String getFrontId() {
        return frontId;
    }

    public List<InstructorDTO> getInstructors() {

        return Collections.unmodifiableList(instructors);
    }

    public List<RentalDTO> getRentalDTOS() {
        return rentalDTOS;
    }

    @Override
    public String toString() {
        return "Models{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", duration=" + duration +
                ", description='" + description + '\'' +
                '}';
    }
    public void assignFrontId(String modelsName, String trainingName){
        this.frontId = modelsName + trainingName;
    }
}
