package com.example.motorcycleDrivingSchool.DTO;

import java.util.List;

public class ProducentDTO {

    private String name;

    private String description;

    private String imgUrl;

    private List<CategoryDTO> producentCategory;

    private  List<ModelsDTO> modelsDTOS;

    public ProducentDTO(String name, List<ModelsDTO> modelsDTOS) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.producentCategory = producentCategory;
        this.modelsDTOS = modelsDTOS;
    }

    public List<ModelsDTO> getModelsDTOS() {
        return modelsDTOS;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public List<CategoryDTO> getProducentCategory() {
        return producentCategory;
    }
}
