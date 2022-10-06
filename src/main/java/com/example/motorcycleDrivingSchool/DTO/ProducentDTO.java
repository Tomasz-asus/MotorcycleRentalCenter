package com.example.motorcycleDrivingSchool.DTO;

import java.util.Collections;
import java.util.List;

public class ProducentDTO {

    private final String name;
    private  String description;
    private  String imgUrl;
    private  List<CategoryDTO> producentCategory;
    private  final List<ModelsDTO> modelsDTOS;
    public ProducentDTO(String name, List<ModelsDTO> modelsDTOS) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.producentCategory = producentCategory;
        this.modelsDTOS = modelsDTOS;
    }
    public List<ModelsDTO> getModelsDTOS() {
        return Collections.unmodifiableList(modelsDTOS);
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
        return Collections.unmodifiableList(producentCategory);
    }
    @Override
    public String toString() {
        return "ProducentDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
