package com.example.tpfinal.controller;

import com.example.tpfinal.entity.Contrat;
import com.example.tpfinal.entity.Equipe;
import com.example.tpfinal.entity.Etudiant;
import com.example.tpfinal.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService EtudiantService;

    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return EtudiantService.getAllEtudiants();
    }

    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable Integer id) {
        return EtudiantService.getEtudiantById(id);
    }

    @PostMapping
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        return EtudiantService.createEtudiant(etudiant);
    }

    @PutMapping("/{id}")
    public Etudiant updateEtudiant(@PathVariable Integer id, @RequestBody Etudiant etudiantDetails) {
        return EtudiantService.updateEtudiant(id, etudiantDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable Integer id) {
        EtudiantService.deleteEtudiant(id);
    }

    @PostMapping("/{id}/contrats")
    public Contrat assignContratToEtudiant(@PathVariable Integer id, @RequestBody Contrat contrat) {
        return EtudiantService.assignContratToEtudiant(id, contrat);
    }

    @GetMapping("/{id}/equipes")
    public List<Equipe> getEquipesByEtudiant(@PathVariable Integer id) {
        return EtudiantService.getEquipesByEtudiant(id);
    }
}

