package com.example.motorcycleDrivingSchool.DTO;

public class InstructorAssignmentDTO {

    private final String instructorName;

    private final String instructorId;

    public InstructorAssignmentDTO(String instructorName,
                                   String instructorId) {
        this.instructorName = instructorName;
        this.instructorId = instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public String getInstructorId() {
        return instructorId;
    }
}
