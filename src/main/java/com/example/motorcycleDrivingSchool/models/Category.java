package com.example.motorcycleDrivingSchool.models;

import javax.persistence.*;
import java.util.Collections;
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

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name="fk_category")
    private List<Producent> categoryProducent;

    public Category(String sport, String description, String imgUrl) {
    }

    public Category() {
    }

    public Category(String name,
                    String description,
                    String imgUrl,
                    List<Producent> categoryProducent) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.categoryProducent = categoryProducent;
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

    public List<Producent> getCategoryProducent() {
        return Collections.unmodifiableList(categoryProducent);
    }

    public void setCategoryProducent(List<Producent> categoryProducent) {
        this.categoryProducent = categoryProducent;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", categoryProducent=" + categoryProducent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return Objects.equals(id, category.id) && Objects.equals(getName(),
                category.getName()) && Objects.equals(getDescription(),
                category.getDescription()) && Objects.equals(getCategoryProducent(), category.getCategoryProducent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getName(), getDescription(), getCategoryProducent());
    }


public void assignProducent (Producent producent){
        this.categoryProducent.add(producent);
}

}
