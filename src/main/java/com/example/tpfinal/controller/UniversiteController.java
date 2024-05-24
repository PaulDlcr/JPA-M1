package com.example.tpfinal.controller;

import com.example.tpfinal.entity.Universite;
import com.example.tpfinal.service.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universites")
public class UniversiteController {
    @Autowired
    private UniversiteService universiteService;

    @GetMapping
    public List<Universite> getAllUniversites() {
        return universiteService.getAllUniversites();
    }

    @GetMapping("/{id}")
    public Universite getUniversiteById(@PathVariable Integer id) {
        return universiteService.getUniversiteById(id);
    }

    @PostMapping
    public Universite createUniversite(@RequestBody Universite universite) {
        return universiteService.createUniversite(universite);
    }

    @DeleteMapping("/{id}")
    public void deleteUniversite(@PathVariable Integer id) {
        universiteService.deleteUniversite(id);
    }
}
