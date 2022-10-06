package com.example.motorcycleDrivingSchool.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double Age;
    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name="unavailableDays")
    private List<InstructorUnavailableDays> unavailableDays = new ArrayList<>();
    public Instructor(String name, double age) {
    }
    public Instructor() {
    }
    public Instructor(String name,
                      double age,
                      List<InstructorUnavailableDays> unavailableDays) {
        this.name = name;
        Age = age;
        this.unavailableDays = unavailableDays;
    }
    public Instructor(String name) {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getAge() {
        return Age;
    }
    public void setAge(double age) {
        Age = age;
    }
    public List<InstructorUnavailableDays> getUnavailableDays() {
        return Collections.unmodifiableList(unavailableDays);
    }
    public void setUnavailableDays(List<InstructorUnavailableDays> unavailableDays) {
        this.unavailableDays = unavailableDays;
    }
    @Override
    public String toString() {
        return "Instructor{" +
                "Name='" + name + '\'' +
                ", Age=" + Age +
                ", unavailableDays=" + unavailableDays +
                '}';
    }
    public void assignUnavailableDays(InstructorUnavailableDays instructorUnavailableDays) {
        this.unavailableDays.add(instructorUnavailableDays);
    }
}
