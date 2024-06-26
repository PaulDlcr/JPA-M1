package com.example.tpfinal.service;

import com.example.tpfinal.entity.Contrat;
import com.example.tpfinal.entity.DetailEquipe;
import com.example.tpfinal.entity.Equipe;
import com.example.tpfinal.entity.Etudiant;
import com.example.tpfinal.repository.ContratRepository;
import com.example.tpfinal.repository.DetailEquipeRepository;
import com.example.tpfinal.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;

    @Autowired
    private DetailEquipeRepository detailEquipeRepository;

    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    public Equipe getEquipeById(Integer id) {
        return equipeRepository.findById(id).orElse(null);
    }

    public Equipe createEquipe(Equipe equipe) {
        if (equipe.getDetailEquipe() != null) {
            detailEquipeRepository.save(equipe.getDetailEquipe());
        }
        return equipeRepository.save(equipe);
    }

    public Equipe updateEquipe(Integer id, Equipe equipeDetails) {
        Equipe equipe = equipeRepository.findById(id).orElse(null);
        if (equipe != null) {
            equipe.setNomEquipe(equipeDetails.getNomEquipe());
            equipe.setNiveau(equipeDetails.getNiveau());

            if (equipeDetails.getDetailEquipe() != null) {
                DetailEquipe detailEquipe = equipeDetails.getDetailEquipe();
                if (detailEquipe.getIdDetailEquipe() == null) {
                    detailEquipeRepository.save(detailEquipe);
                } else {
                    DetailEquipe existingDetail = detailEquipeRepository.findById(detailEquipe.getIdDetailEquipe()).orElse(null);
                    if (existingDetail != null) {
                        existingDetail.setSalle(detailEquipe.getSalle());
                        existingDetail.setThematique(detailEquipe.getThematique());
                        detailEquipeRepository.save(existingDetail);
                    } else {
                        detailEquipeRepository.save(detailEquipe);
                    }
                }
            }

            return equipeRepository.save(equipe);
        }
        return null;
    }

    public void deleteEquipe(Integer id) {
        equipeRepository.deleteById(id);
    }

    public List<Contrat> getContratsByEquipe(Integer equipeId) {
        Equipe equipe = equipeRepository.findById(equipeId).orElse(null);
        if (equipe != null) {
            List<Etudiant> etudiants = equipe.getEtudiants();
            List<Contrat> contrats = new ArrayList<>();
            for (Etudiant etudiant : etudiants) {
                contrats.addAll(etudiant.getContrats());
            }
            return contrats;
        }
        return Collections.emptyList();
    }
}