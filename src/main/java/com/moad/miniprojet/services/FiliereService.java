package com.moad.miniprojet.services;

import com.moad.miniprojet.entities.Filiere;
import com.moad.miniprojet.repositories.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FiliereService {

    @Autowired
    private FiliereRepository filiereRepository;

    public List<Filiere> getAllFilieres() {
        return filiereRepository.findAll();
    }

    public Filiere getFiliereById(Long id) {
        return filiereRepository.findById(id).orElse(null);
    }

    public Filiere saveFiliere(Filiere filiere) {
        return filiereRepository.save(filiere);
    }

    public boolean canDelete(Long id) {
        Filiere filiere = filiereRepository.findById(id).orElse(null);
        if (filiere == null) return false;
        
        boolean hasEleves = filiere.getEleves() != null && !filiere.getEleves().isEmpty();
        boolean hasCours = filiere.getCours() != null && !filiere.getCours().isEmpty();
        
        return !hasEleves && !hasCours;
    }

    public void deleteFiliere(Long id) {
        filiereRepository.deleteById(id);
    }
}
