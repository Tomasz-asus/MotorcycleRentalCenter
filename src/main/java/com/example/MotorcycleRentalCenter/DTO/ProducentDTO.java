package com.example.MotorcycleRentalCenter.DTO;

import java.util.Collections;
import java.util.List;

public class ProducentDTO {

    private String name;
    private List<ModelsDTO> models;

    public ProducentDTO(String name, List<ModelsDTO> models) {
        this.name = name;
        this.models = models;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ModelsDTO> getModels() {
        return Collections.unmodifiableList(models);
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", models=" + models +
                '}';
    }
}
