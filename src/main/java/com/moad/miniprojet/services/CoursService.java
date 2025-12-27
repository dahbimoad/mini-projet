package com.moad.miniprojet.services;

import com.moad.miniprojet.entities.Cours;
import com.moad.miniprojet.entities.Eleve;
import com.moad.miniprojet.repositories.CoursRepository;
import com.moad.miniprojet.repositories.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CoursService {

    @Autowired
    private CoursRepository coursRepository;

    @Autowired
    private EleveRepository eleveRepository;

    public List<Cours> getAllCours() {
        return coursRepository.findAll();
    }

    public Cours getCoursById(Long id) {
        return coursRepository.findById(id).orElse(null);
    }

    public Cours saveCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Transactional
    public boolean deleteCours(Long id) {
        Cours cours = coursRepository.findById(id).orElse(null);
        if (cours == null) return false;
        
        List<Eleve> eleves = cours.getEleves();
        if (eleves != null) {
            for (Eleve eleve : eleves) {
                eleve.getCours().remove(cours);
                eleveRepository.save(eleve);
            }
        }
        
        coursRepository.deleteById(id);
        return true;
    }
}
