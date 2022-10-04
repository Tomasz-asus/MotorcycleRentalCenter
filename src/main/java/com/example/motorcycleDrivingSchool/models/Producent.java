package com.example.motorcycleDrivingSchool.models;


import com.sun.mail.imap.Rights;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
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
    private String models;

    public Producent() {
    }

    public Producent(String name,
                     String description,
                     String imgUrl,
                     List<Category> producentCategory,
                     String models) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.producentCategory = producentCategory;
        this.models = models;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "fk_producentCategory")
    private List<Category> producentCategory;

    public <R> Producent(String name, String description, String imgUrl, R collect) {
    }

    public <R> Producent(String name, R collect) {
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Models> getModels() {
        return Collections.unmodifiableList(getModels());
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", models='" + models + '\''+
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
        return Objects.hash(id, getName(), getDescription(), getImgUrl(), producentCategory, models);
    }

}

