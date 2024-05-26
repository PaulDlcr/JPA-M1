package com.example.tpfinal.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUniv;
    private String nomUniv;

    @OneToMany(mappedBy = "universite", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Departement> departements;

    // Getters and Setters
    public Integer getIdUniv() {
        return idUniv;
    }

    public void setIdUniv(Integer idUniv) {
        this.idUniv = idUniv;
    }

    public String getNomUniv() {
        return nomUniv;
    }

    public void setNomUniv(String nomUniv) {
        this.nomUniv = nomUniv;
    }

    public List<Departement> getDepartements() {
        return departements;
    }

    public void setDepartements(List<Departement> departements) {
        this.departements = departements;
    }
}
