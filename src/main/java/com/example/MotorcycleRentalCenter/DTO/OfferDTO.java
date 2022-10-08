package com.example.MotorcycleRentalCenter.DTO;

import java.util.List;

public class OfferDTO {

    private final String email;
    private final List<ModelsDTO> modelsDTOS;

    public OfferDTO(String email,
                    List<ModelsDTO> modelsDTOS) {
        this.email = email;
        this.modelsDTOS = modelsDTOS;

    }

    public String getEmail() {
        return email;
    }

    public List<ModelsDTO> getModelsDTOSDTOS() {
        return modelsDTOS;
    }
}
