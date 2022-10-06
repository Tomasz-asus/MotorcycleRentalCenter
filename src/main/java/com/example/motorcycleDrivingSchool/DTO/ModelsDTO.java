package com.example.motorcycleDrivingSchool.DTO;

import java.util.Collections;
import java.util.List;

public class ModelsDTO {

    private String name;
    private double duration;
    private double price;
    private String description;
    private String frontId;
    private List<InstructorDTO> instructor;
    private List<RentalDTO> rentalDTO;

    public ModelsDTO(String name,
                     double duration,
                     double price,
                     String description,
                     String frontId,
                     List<InstructorDTO> instructor,
                     List<RentalDTO> rentalDTO) {
        this.name = name;
        this.duration = duration;
        this.price = price;
        this.description = description;
        this.frontId = frontId;
        this.instructor = instructor;
        this.rentalDTO = rentalDTO;
    }

    public ModelsDTO(String jjj, int duration, int price, String jj, String k, List<InstructorDTO> ff, List<RentalDTO> rentalDTO, List<RentalDTO> rentalDTO1) {
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
