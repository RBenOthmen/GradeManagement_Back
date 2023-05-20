package com.example.grademanagement.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Module implements Serializable {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @OneToMany(mappedBy = "module")
    private List<Subject> subjects = new ArrayList<>();

    @ManyToMany(mappedBy = "modules")
    private List<Student> students = new ArrayList<>();

    public Module(List<Subject> subjects) {}

    public Module() {}


    public Long getId() {
        return id;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void calculMoyenne() {}
}
