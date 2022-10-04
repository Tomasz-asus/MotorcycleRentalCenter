package com.example.motorcycleDrivingSchool.models;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Producent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String description;

    private String imgUrl;


    public Producent() {
    }

    public Producent(String name, String description, String imgUrl, List<Category> producentCategory) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.producentCategory = producentCategory;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "fk_producentCategory")
    private List<Category> producentCategory;

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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producent producent)) return false;
        return id == producent.id && Objects.equals(getName(), producent.getName()) && Objects.equals(getDescription(), producent.getDescription()) && Objects.equals(getImgUrl(), producent.getImgUrl()) && Objects.equals(producentCategory, producent.producentCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getName(), getDescription(), getImgUrl(), producentCategory);
    }
}

