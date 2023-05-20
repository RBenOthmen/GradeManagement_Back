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

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    @ManyToMany(mappedBy = "subjects")
    private List<Teacher> teachers = new ArrayList<>();

    public Subject(String name, int coefficient) {
        this.name = name;
        this.coefficient = coefficient;
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

}
