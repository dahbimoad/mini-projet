package com.moad.miniprojet.services;

import com.moad.miniprojet.entities.DossierAdministratif;
import com.moad.miniprojet.entities.Eleve;
import com.moad.miniprojet.repositories.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class EleveService {

    @Autowired
    private EleveRepository eleveRepository;

    public List<Eleve> getAllEleves() {
        return eleveRepository.findAll();
    }

    public Eleve getEleveById(Long id) {
        return eleveRepository.findById(id).orElse(null);
    }

    public Eleve saveEleve(Eleve eleve) {
        if (eleve.getId() == null) {
            // Création automatique du dossier administratif
            DossierAdministratif dossier = new DossierAdministratif();
            dossier.setDateCreation(LocalDate.now());
            eleve.setDossierAdministratif(dossier);
            
            // Sauvegarder d'abord pour obtenir l'ID
            Eleve savedEleve = eleveRepository.save(eleve);
            
            // Générer le numéro d'inscription : FILIERE-ANNEE-ID
            String codeFiliere = savedEleve.getFiliere() != null ? savedEleve.getFiliere().getCode() : "NONE";
            String annee = String.valueOf(LocalDate.now().getYear());
            String numeroInscription = codeFiliere + "-" + annee + "-" + savedEleve.getId();
            savedEleve.getDossierAdministratif().setNumeroInscription(numeroInscription);
            
            return eleveRepository.save(savedEleve);
        }
        return eleveRepository.save(eleve);
    }

    public void deleteEleve(Long id) {
        eleveRepository.deleteById(id);
    }
}
