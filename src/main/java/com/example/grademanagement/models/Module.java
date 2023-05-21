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

    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST) // Cascade the save operation to associated subjects
    private List<Subject> subjects = new ArrayList<>();

    @ManyToMany(mappedBy = "modules")
    private List<Student> students = new ArrayList<>();


    public Module(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;

        for (Subject subject : subjects) {
            subject.setModule(this);
        }
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void calculMoyenne() {}

    public void addSubject(Subject subject) {
        subjects.add(subject);
        subject.setModule(this);
    }
}
