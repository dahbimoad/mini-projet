package com.moad.miniprojet.services;

import com.moad.miniprojet.entities.DossierAdministratif;
import com.moad.miniprojet.entities.Eleve;
import com.moad.miniprojet.repositories.DossierAdministratifRepository;
import com.moad.miniprojet.repositories.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class DossierAdministratifService {

    @Autowired
    private DossierAdministratifRepository dossierAdministratifRepository;

    @Autowired
    private EleveRepository eleveRepository;

    public List<DossierAdministratif> getAllDossiers() {
        return dossierAdministratifRepository.findAll();
    }

    public DossierAdministratif getDossierById(Long id) {
        return dossierAdministratifRepository.findById(id).orElse(null);
    }

    public DossierAdministratif saveDossier(DossierAdministratif dossier) {
        return dossierAdministratifRepository.save(dossier);
    }

    @Transactional
    public boolean deleteDossier(Long id) {
        DossierAdministratif dossier = dossierAdministratifRepository.findById(id).orElse(null);
        if (dossier == null) return false;
        
        Eleve eleve = dossier.getEleve();
        if (eleve != null) {
            eleve.setDossierAdministratif(null);
            eleveRepository.save(eleve);
        }
        
        dossierAdministratifRepository.deleteById(id);
        return true;
    }
}
