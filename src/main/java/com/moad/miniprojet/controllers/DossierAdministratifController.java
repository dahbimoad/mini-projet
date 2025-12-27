package com.moad.miniprojet.controllers;

import com.moad.miniprojet.entities.DossierAdministratif;
import com.moad.miniprojet.services.DossierAdministratifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dossiers")
public class DossierAdministratifController {

    @Autowired
    private DossierAdministratifService dossierAdministratifService;

    @GetMapping
    public String listDossiers(Model model) {
        model.addAttribute("dossiers", dossierAdministratifService.getAllDossiers());
        return "dossiers/list";
    }

    @GetMapping("/edit/{id}")
    public String editDossierForm(@PathVariable Long id, Model model) {
        DossierAdministratif dossier = dossierAdministratifService.getDossierById(id);
        model.addAttribute("dossier", dossier);
        return "dossiers/edit";
    }

    @PostMapping("/update")
    public String updateDossier(@ModelAttribute DossierAdministratif dossier) {
        dossierAdministratifService.saveDossier(dossier);
        return "redirect:/dossiers";
    }

    @GetMapping("/delete/{id}")
    public String deleteDossier(@PathVariable Long id) {
        dossierAdministratifService.deleteDossier(id);
        return "redirect:/dossiers";
    }
}
