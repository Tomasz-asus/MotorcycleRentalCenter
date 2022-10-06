package com.example.motorcycleDrivingSchool.DTO;

import java.util.List;

public class OfferDTO {
    private String email;
    private List<ModelsDTO> modelsDTOS;

    public OfferDTO(String email, List<ModelsDTO> modelsDTOS) {
        this.email = email;
        this.modelsDTOS = modelsDTOS;
    }

    public OfferDTO() {
    }

    public String getEmail() {
        return email;
    }

    public List<ModelsDTO> getModelsDTOS() {
        return modelsDTOS;
    }
}
