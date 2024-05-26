package com.example.tpfinal.controller;

import com.example.tpfinal.entity.Departement;
import com.example.tpfinal.entity.Universite;
import com.example.tpfinal.service.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/universites")
public class UniversiteController {

    @Autowired
    private UniversiteService serviceUniversite;

    @GetMapping
    public List<Universite> getAllUniversites() {
        return serviceUniversite.getAllUniversites();
    }

    @GetMapping("/{id}")
    public Universite getUniversiteById(@PathVariable Integer id) {
        return serviceUniversite.getUniversiteById(id);
    }

    @PostMapping
    public Universite createUniversite(@RequestBody Universite universite) {
        return serviceUniversite.createUniversite(universite);
    }

    @PutMapping("/{id}")
    public Universite updateUniversite(@PathVariable Integer id, @RequestBody Universite universiteDetails) {
        return serviceUniversite.updateUniversite(id, universiteDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteUniversite(@PathVariable Integer id) {
        serviceUniversite.deleteUniversite(id);
    }

    @GetMapping("/{id}/departements")
    public List<Departement> getDepartementsByUniversite(@PathVariable Integer id) {
        return serviceUniversite.getDepartementsByUniversite(id);
    }

    @PostMapping("/{id}/departements")
    public Departement assignDepartementToUniversite(@PathVariable Integer id, @RequestBody Departement departement) {
        return serviceUniversite.assignDepartementToUniversite(id, departement);
    }
}