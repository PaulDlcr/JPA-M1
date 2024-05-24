package com.example.tpfinal.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUniv;
    private String nomUniv;

    @OneToMany(mappedBy = "universite")
    private List<Departement> departements;

    // Getters and Setters

}
