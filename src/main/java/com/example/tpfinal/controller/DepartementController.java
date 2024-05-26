package com.example.tpfinal.controller;

import com.example.tpfinal.entity.Departement;
import com.example.tpfinal.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departements")
public class DepartementController {

    @Autowired
    private DepartementService departementService;

    @GetMapping
    public List<Departement> getAllDepartements() {
        return departementService.getAllDepartements();
    }

    @GetMapping("/{id}")
    public Departement getDepartementById(@PathVariable Integer id) {
        return departementService.getDepartementById(id);
    }

    @PostMapping
    public Departement createDepartement(@RequestBody Departement departement) {
        return departementService.createDepartement(departement);
    }

    @PutMapping("/{id}")
    public Departement updateDepartement(@PathVariable Integer id, @RequestBody Departement departementDetails) {
        return departementService.updateDepartement(id, departementDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartement(@PathVariable Integer id) {
        departementService.deleteDepartement(id);
    }
}
