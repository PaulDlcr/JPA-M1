package com.example.tpfinal.service;

import com.example.tpfinal.entity.Departement;
import com.example.tpfinal.entity.Universite;
import com.example.tpfinal.repository.DepartementRepository;
import com.example.tpfinal.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UniversiteService {

    @Autowired
    private UniversiteRepository universiteRepository;

    @Autowired
    private DepartementRepository departementRepository;

    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    public Universite getUniversiteById(Integer id) {
        return universiteRepository.findById(id).orElse(null);
    }

    public Universite createUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    public Universite updateUniversite(Integer id, Universite universiteDetails) {
        Universite universite = universiteRepository.findById(id).orElse(null);
        if (universite != null) {
            universite.setNomUniv(universiteDetails.getNomUniv());
            return universiteRepository.save(universite);
        }
        return null;
    }

    public void deleteUniversite(Integer id) {
        universiteRepository.deleteById(id);
    }

    public List<Departement> getDepartementsByUniversite(Integer universiteId) {
        Universite universite = universiteRepository.findById(universiteId).orElse(null);
        if (universite != null) {
            return universite.getDepartements();
        }
        return Collections.emptyList();
    }

    public Departement assignDepartementToUniversite(Integer universiteId, Departement departement) {
        Universite universite = universiteRepository.findById(universiteId).orElse(null);
        if (universite != null) {
            departement.setUniversite(universite);
            return departementRepository.save(departement);
        }
        return null;
    }
}