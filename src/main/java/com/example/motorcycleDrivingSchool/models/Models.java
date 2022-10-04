package com.example.motorcycleDrivingSchool.models;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Models {

@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String duration;

    private double price;

    private String description;

    private String frontId;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "fk_modelsRental")
    private List<Rental> modelsRental;

    @ManyToMany
    private List<Instructor> instructor;

    public Models(String name, String duration, double price, String description, String frontId, List<Instructor> instructors, List<Rental> rentals) {
    }

    public Models(String name, String duration, double price, String description, List<Rental> modelsRental, List<Instructor> instructor) {
        this.name = name;
        this.duration = duration;
        this.price = price;
        this.description = description;
        this.modelsRental = modelsRental;
        this.instructor = instructor;
    }

    public Models() {
    }

    public String getName() {
        return name;
    }

    public String getFrontId() {
        return frontId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Rental> getModelsRental() {
        return modelsRental;
    }

    public void setModelsRental(List<Rental> modelsRental) {
        this.modelsRental = modelsRental;
    }

    public List<Instructor> getInstructor() {
        return instructor;
    }

    public void setInstructor(List<Instructor> instructor) {
        this.instructor = instructor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Models models)) return false;
        return Double.compare(models.getPrice(), getPrice()) == 0 && Objects.equals(id, models.id) && Objects.equals(getName(), models.getName()) && Objects.equals(getDuration(), models.getDuration()) && Objects.equals(getDescription(), models.getDescription()) && Objects.equals(getModelsRental(), models.getModelsRental()) && Objects.equals(getInstructor(), models.getInstructor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getName(), getDuration(), getPrice(), getDescription(), getModelsRental(), getInstructor());
    }

    public void assignInstructor(Instructor instructor) {
    }
}
