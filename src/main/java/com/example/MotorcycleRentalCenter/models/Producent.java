package com.example.MotorcycleRentalCenter.models;



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
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Models> models;

    public Producent(String name, List<Models> models) {
        this.name = name;
        this.models = models;
    }

    public Producent() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Models> getModels() {
        return Collections.unmodifiableList(models);
    }

    public void setModels(List<Models> models) {
        this.models = models;
    }

    @Override
    public String toString() {
        return "Producent{" +
                "name='" + name + '\'' +
                ", model=" + models +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producent that = (Producent) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(models, that.models);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, models);
    }

    public void assignModels(Models models){
        this.models.add(models);
    }
}
