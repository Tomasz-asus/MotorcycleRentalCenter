package com.example.motorcycleDrivingSchool.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Collections;
import java.util.List;

public class CategoryDTO {

    private final String name;
    private final String description;
    private final String imgUrl;
    private List<ProducentDTO> list;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CategoryDTO(String name,
                       String imgUrl,
                       String description,
                       List<ProducentDTO> list) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.description = description;
        this.list = list;
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
    public List<ProducentDTO> getList() {
        return Collections.unmodifiableList(list);
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}

