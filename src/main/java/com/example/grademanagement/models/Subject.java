package com.example.grademanagement.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private int coefficient;
    private double grade;
    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;
    @ManyToMany(mappedBy = "subjects")
    private List<Teacher> teachers = new ArrayList<>();


    public Subject(String name, int coefficient, double grade) {
        this.name = name;
        this.coefficient = coefficient;
        this.grade = grade;
    }

    public Subject() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
