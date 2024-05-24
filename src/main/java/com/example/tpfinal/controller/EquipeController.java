package com.example.tpfinal.controller;

import com.example.tpfinal.entity.Contrat;
import com.example.tpfinal.entity.Equipe;
import com.example.tpfinal.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipes")
public class EquipeController {

    @Autowired
    private EquipeService EquipeService;

    @GetMapping
    public List<Equipe> getAllEquipes() {
        return EquipeService.getAllEquipes();
    }

    @GetMapping("/{id}")
    public Equipe getEquipeById(@PathVariable Integer id) {
        return EquipeService.getEquipeById(id);
    }

    @PostMapping
    public Equipe createEquipe(@RequestBody Equipe equipe) {
        return EquipeService.createEquipe(equipe);
    }

    @PutMapping("/{id}")
    public Equipe updateEquipe(@PathVariable Integer id, @RequestBody Equipe equipeDetails) {
        return EquipeService.updateEquipe(id, equipeDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipe(@PathVariable Integer id) {
        EquipeService.deleteEquipe(id);
    }

    @GetMapping("/{id}/contrats")
    public List<Contrat> getContratsByEquipe(@PathVariable Integer id) {
        return EquipeService.getContratsByEquipe(id);
    }
}

