package com.example.grademanagement.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Admin extends User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String first_name;
    private String last_name;


    public Admin(String first_name, String last_name) {
        super(first_name, last_name);
    }

    public Admin() {}
}
