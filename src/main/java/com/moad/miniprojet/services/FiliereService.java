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

    public void deleteFiliere(Long id) {
        filiereRepository.deleteById(id);
    }
}
