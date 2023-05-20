package com.example.grademanagement.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String first_name;
    private String last_name;

    @ManyToMany
    private List<Module> modules = new ArrayList<>();

    private double moyenneGenerale;


    public Student(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Student() {}


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}
