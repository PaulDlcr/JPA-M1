package com.example.tpfinal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepart;
    private String nomDepart;

    @ManyToOne
    @JoinColumn(name = "universite_id")
    @JsonBackReference
    private Universite universite;

    @OneToMany(mappedBy = "departement", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;

    // Getters and Setters
    public Integer getIdDepart() {
        return idDepart;
    }

    public void setIdDepart(Integer idDepart) {
        this.idDepart = idDepart;
    }

    public String getNomDepart() {
        return nomDepart;
    }

    public void setNomDepart(String nomDepart) {
        this.nomDepart = nomDepart;
    }

    public Universite getUniversite() {
        return universite;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
}