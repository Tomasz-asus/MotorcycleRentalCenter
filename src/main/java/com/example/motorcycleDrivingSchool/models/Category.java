package com.example.motorcycleDrivingSchool.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String imgUrl;
    private String description;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Models> categoryModels;

    public Category() {
    }

    public Category(String name,
                    String description,
                    String imgUrl,
                    List<Models> categoryModels) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.categoryModels = categoryModels;
    }

    public <R> Category(String name, R collect) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Models> getCategoryModels() {
        return categoryModels;
    }

    public void setCategoryModels(List<Models> categoryModels) {
        this.categoryModels = categoryModels;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", categoryModels=" + categoryModels +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return Objects.equals(id, category.id) && Objects.equals(getName(), category.getName()) && Objects.equals(getDescription(), category.getDescription()) && Objects.equals(getCategoryModels(), category.getCategoryModels());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getName(), getDescription(), getCategoryModels());
    }
}
