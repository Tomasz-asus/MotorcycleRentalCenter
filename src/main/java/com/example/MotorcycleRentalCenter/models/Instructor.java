package com.example.MotorcycleRentalCenter.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String bio;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "fk_category2")
    private List<InstructorUnavailableDays> unavailableDays = new ArrayList<>();

    public Instructor(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

    public Instructor(String name) {
        this.name = name;
    }

    public Instructor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public List<InstructorUnavailableDays> getUnavailableDays() {
        return Collections.unmodifiableList(unavailableDays);
    }

    public void assignUnavailableDays(InstructorUnavailableDays instructorUnavailableDays){
        this.unavailableDays.add(instructorUnavailableDays);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "name='" + name + '\'' +
                ", specialization='" + bio + '\'' +
                '}';
    }
}
