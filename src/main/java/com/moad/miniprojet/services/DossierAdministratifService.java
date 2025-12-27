package com.moad.miniprojet.services;

import com.moad.miniprojet.entities.DossierAdministratif;
import com.moad.miniprojet.repositories.DossierAdministratifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DossierAdministratifService {

    @Autowired
    private DossierAdministratifRepository dossierAdministratifRepository;

    public List<DossierAdministratif> getAllDossiers() {
        return dossierAdministratifRepository.findAll();
    }

    public DossierAdministratif getDossierById(Long id) {
        return dossierAdministratifRepository.findById(id).orElse(null);
    }

    public DossierAdministratif saveDossier(DossierAdministratif dossier) {
        return dossierAdministratifRepository.save(dossier);
    }

    public void deleteDossier(Long id) {
        dossierAdministratifRepository.deleteById(id);
    }
}
