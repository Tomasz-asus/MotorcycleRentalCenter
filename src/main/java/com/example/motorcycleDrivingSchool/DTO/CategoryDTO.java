package com.example.motorcycleDrivingSchool.DTO;

import java.util.List;

public class CategoryDTO {

    private final String name;
    private List<ProducentDTO> producentDTOS;
    private List<ModelsDTO> modelsDTOS;

    public CategoryDTO(String name, List<ModelsDTO> modelsDTOS) {
        this.name = name;
        this.modelsDTOS = modelsDTOS;
        this.producentDTOS = producentDTOS;
    }

    public String getName() {
        return name;
    }

    public List<ModelsDTO> getModelsDTOS() {
        return modelsDTOS;
    }

    public List<ProducentDTO> getProducentDTOS() {
        return producentDTOS;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "name='" + name + '\'' +
                ", producentDTOS=" + producentDTOS +
                ", modelsDTOS=" + modelsDTOS +
                '}';
    }
}
