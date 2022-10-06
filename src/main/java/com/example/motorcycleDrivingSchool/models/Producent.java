package com.example.motorcycleDrivingSchool.models;



import javax.persistence.*;
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
    public Producent() {
    }
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Models> models;
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
    public String getImgUrl() {
        return imgUrl;
    }
    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", models='" + models + '\'' +
                '}';
    }
    public List<Models> getModels(){
        return Collections.unmodifiableList(models);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producent producent)) return false;
        return id == producent.id && Objects.equals(getName(), producent.getName()) && Objects.equals(getDescription(), producent.getDescription()) && Objects.equals(getImgUrl(), producent.getImgUrl()) && Objects.equals(getModels(), producent.getModels());
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, getName(), getDescription(), getImgUrl(), getModels());
    }
    public void assignTypeOfModels(Models models) {
    this.models.add(models);
    }
}
