package com.example.motorcycleDrivingSchool.DTO;

import java.util.Collections;
import java.util.List;

public class CategoryDTO {

    private final String name;

    private final String imgUrl;

    private final String description;

    private List<ProducentDTO> producentDTOS;

    private List<ModelsDTO> modelsDTOS;

    public CategoryDTO(String name,
                       String imgUrl,
                       String description,
                       List<ProducentDTO> producentDTOS) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.description = description;
        this.producentDTOS = producentDTOS;

    }

    public CategoryDTO(String name, String descriptions, String imgUrl, List<CategoryDTO> list, String name1, String imgUrl1, String description) {
        this.name = name1;
        this.imgUrl = imgUrl1;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public List<ProducentDTO> getList() {
        return producentDTOS;
    }

    public List<ProducentDTO> getModelsDTOS() {
        return Collections.unmodifiableList(producentDTOS);
    }
}

