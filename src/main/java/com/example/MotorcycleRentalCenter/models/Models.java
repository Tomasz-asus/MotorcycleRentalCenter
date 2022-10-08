package com.example.MotorcycleRentalCenter.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
public class Models {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private double price;
    private double duration;
    private String description;
    private String frontId;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "fk_category3")
    private List<Rental> rental;
    @ManyToMany
    private List<Instructor> instructor;

    public Models(String name,
                  double price,
                  double duration,
                  String description,
                  String frontId,
                  List<Instructor> instructor,
                  List<Rental> rental) {
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.description = description;
        this.frontId = frontId;
        this.instructor = instructor;
        this.rental = rental;
    }

    public Models(String name, double price, double duration, String description, String frontId) {
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.description = description;
        this.frontId = frontId;
        this.instructor = new ArrayList<>();
        this.rental = new ArrayList<>();
    }

    public Models() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public double getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public String getFrontId() {
        return frontId;
    }

    public List<Rental> getRental() {
        return Collections.unmodifiableList(rental);
    }

    public List<Instructor> getInstructor() {
        return Collections.unmodifiableList(instructor);
    }

    @Override
    public String toString() {
        return "Models{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", duration=" + duration +
                ", description='" + description + '\'' +
                ", instructor=" + instructor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Models that = (Models) o;
        return id == that.id && Double.compare(that.price, price) == 0 && Double.compare(that.duration, duration) == 0 && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(instructor, that.instructor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, duration, description, instructor);
    }

    public void assignInstructor(Instructor instructor) {
        this.instructor.add(instructor);
    }
    public void assignRental(Rental rental){
        this.rental.add(rental);
    }
}
