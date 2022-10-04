package com.example.motorcycleDrivingSchool.DTO;

import java.util.List;

public class ProducentDTO {

    private final String name;

    private final String description;

    private final String imgUrl;

    private final List<CategoryDTO> producentCategory;


    public ProducentDTO(String name, String description, String imgUrl, List<CategoryDTO> producentCategory) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.producentCategory = producentCategory;
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

    @Override
    public String toString() {
        return "ProducentDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", producentCategory=" + producentCategory +
                '}';
    }
}
