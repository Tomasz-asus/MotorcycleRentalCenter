package com.example.motorcycleDrivingSchool.DTO;

import java.util.Collections;
import java.util.List;

public class ModelsDTO {

    private final String name;
    private final double duration;
    private final double price;
    private final String description;
    private String frontId;
    private final List<RentalDTO> rentalDTO;
    private final List<InstructorDTO> instructor;

    public ModelsDTO(String name,
                     double duration,
                     double price,
                     String description,
                     String frontId,
                     List<RentalDTO> rentalDTO,
                     List<InstructorDTO> instructor) {
        this.name = name;
        this.duration = duration;
        this.price = price;
        this.description = description;
        this.frontId = frontId;
        this.rentalDTO = rentalDTO;
        this.instructor = instructor;
    }
    public String getName() {
        return name;
    }
    public double getDuration() {
        return duration;
    }
    public double getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }
    public String getFrontId() {
        return frontId;
    }
    public List<RentalDTO> getRentalDTO() {
        return rentalDTO;
    }
    public List<InstructorDTO> getInstructor() {
        return Collections.unmodifiableList(instructor);
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
    public void  assignFrontId( String modelsName, String rentalName){
        this.frontId = modelsName + rentalName;
    }
}
