package com.example.tpfinal.service;

import com.example.tpfinal.entity.Contrat;
import com.example.tpfinal.entity.Equipe;
import com.example.tpfinal.entity.Etudiant;
import com.example.tpfinal.repository.ContratRepository;
import com.example.tpfinal.repository.EquipeRepository;
import com.example.tpfinal.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private EquipeRepository equipeRepository;

    @Autowired
    private ContratRepository contratRepository;

    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    public Etudiant getEtudiantById(Integer id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    public Etudiant createEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public Etudiant updateEtudiant(Integer id, Etudiant etudiantDetails) {
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        if (etudiant != null) {
            etudiant.setPrenomE(etudiantDetails.getPrenomE());
            etudiant.setNomE(etudiantDetails.getNomE());
            etudiant.setOption(etudiantDetails.getOption());
            etudiant.setDepartement(etudiantDetails.getDepartement());
            return etudiantRepository.save(etudiant);
        }
        return null;
    }

    public void deleteEtudiant(Integer id) {
        etudiantRepository.deleteById(id);
    }

    public List<Equipe> getEquipesByEtudiant(Integer etudiantId) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId).orElse(null);
        if (etudiant != null) {
            return etudiant.getEquipes(); // Assuming you have a list of Equipes in Etudiant
        }
        return Collections.emptyList();
    }

    public Contrat assignContratToEtudiant(Integer etudiantId, Contrat contrat) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId).orElse(null);
        if (etudiant != null) {
            contrat.setEtudiant(etudiant);
            return contratRepository.save(contrat);
        }
        return null;
    }
}

