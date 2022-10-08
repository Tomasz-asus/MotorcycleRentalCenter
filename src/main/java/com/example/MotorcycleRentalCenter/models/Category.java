package com.example.MotorcycleRentalCenter.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private String imgUrl;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "fk_category")
    private List<Producent> shopsCategories;

    public Category() {
    }
    public Category(String name,
                    String description,
                    String imgUrl) {
        this(name, description, imgUrl, new ArrayList<>());
    }
    public Category(String name,
                    String description,
                    String imgUrl,
                    List<Producent> shopsCategories) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.shopsCategories = shopsCategories;
    }
    public Category(String name,
                    String description,
                    List<Producent> shopsCathegories) {
        this.name = name;
        this.description = description;
        this.shopsCategories = shopsCathegories;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Producent> getShopsCategories() {
        return Collections.unmodifiableList(shopsCategories);
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", shopsCategories=" + shopsCategories +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category
                .id && Objects
                .equals(name, category.name) && Objects
                .equals(description, category.description) && Objects
                .equals(imgUrl, category.imgUrl) && Objects
                .equals(shopsCategories, category.shopsCategories);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, imgUrl, shopsCategories);
    }
    public void asssignProducent(Producent producent){
        this.shopsCategories.add(producent);
    }

}
