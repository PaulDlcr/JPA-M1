package com.example.tpfinal.service;

import com.example.tpfinal.entity.Universite;
import com.example.tpfinal.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversiteService {
    @Autowired
    private UniversiteRepository universiteRepository;

    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    public Universite getUniversiteById(Integer id) {
        return universiteRepository.findById(id).orElse(null);
    }

    public Universite createUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    public void deleteUniversite(Integer id) {
        universiteRepository.deleteById(id);
    }
}

