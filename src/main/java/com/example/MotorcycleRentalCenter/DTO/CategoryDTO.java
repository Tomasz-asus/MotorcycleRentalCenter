package com.example.MotorcycleRentalCenter.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Collections;
import java.util.List;

public class CategoryDTO {
    private final String name;
    private final String description;
    private final String imgUrl;
    private final List<ProducentDTO> list;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CategoryDTO(String name,
                       String description,
                       String imgUrl,
                       List<ProducentDTO> list) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.list = list;
    }

    public List<ProducentDTO> getList() {
        return Collections.unmodifiableList(list);
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

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
