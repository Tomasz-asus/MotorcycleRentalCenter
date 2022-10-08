package com.example.MotorcycleRentalCenter.DTO;

public class InstructorAssignmentDTO {

    private final String instructorName;
    private final String modelsName;

    public InstructorAssignmentDTO(String instructorName, String modelsName) {
        this.instructorName = instructorName;
        this.modelsName = modelsName;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public String getModelsName() {
        return modelsName;
    }
}
