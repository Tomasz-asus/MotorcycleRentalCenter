package com.example.motorcycleDrivingSchool.DTO;

public class PeriodAndInstructorAssignDTO {
    private final RentalDTO rentalDTO;
    private final InstructorDTO instructorDTO;

    public PeriodAndInstructorAssignDTO(RentalDTO rentalDTO,
                                        InstructorDTO instructorDTO) {
        this.rentalDTO = rentalDTO;
        this.instructorDTO = instructorDTO;
    }

    public RentalDTO getRentalDTO() {
        return rentalDTO;
    }

    public InstructorDTO getInstructorDTO() {
        return instructorDTO;
    }
}
