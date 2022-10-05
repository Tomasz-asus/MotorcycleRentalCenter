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
    @JoinColumn(name = "fk_models")
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
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getName(), getDescription(), getImgUrl(), models);
    }

    public void assignTypeOfModels(Models models) {
    }

}
