package com.example.motorcycleDrivingSchool.DTO;

import java.util.List;

public class CategoryDTO {

    private String name;

    private final List<ModelsDTO> modelsDTOS;

    public CategoryDTO(String name, List<ModelsDTO> modelsDTOS) {
        this.name = name;
        this.modelsDTOS = modelsDTOS;
    }

    public String getName() {
        return name;
    }

    public List<ModelsDTO> getModelsDTOS() {
        return modelsDTOS;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "name='" + name + '\'' +
                ", modelsDTOS=" + modelsDTOS +
                '}';
    }
}
