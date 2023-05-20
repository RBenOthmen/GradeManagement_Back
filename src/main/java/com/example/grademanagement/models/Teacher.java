package com.example.grademanagement.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String first_name;
    private String last_name;

    @ManyToMany
    private List<Subject> subjects = new ArrayList<>();


    public Teacher(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Teacher() {}
}
