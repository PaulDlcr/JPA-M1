package com.example.tpfinal.service;

import com.example.tpfinal.entity.Departement;
import com.example.tpfinal.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementService {

    @Autowired
    private DepartementRepository departementRepository;

    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    public Departement getDepartementById(Integer id) {
        return departementRepository.findById(id).orElse(null);
    }

    public Departement createDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    public Departement updateDepartement(Integer id, Departement departementDetails) {
        Departement departement = departementRepository.findById(id).orElse(null);
        if (departement != null) {
            departement.setNomDepart(departementDetails.getNomDepart());
            departement.setUniversite(departementDetails.getUniversite());
            return departementRepository.save(departement);
        }
        return null;
    }

    public void deleteDepartement(Integer id) {
        departementRepository.deleteById(id);
    }
}
