package com.moad.miniprojet.controllers;

import com.moad.miniprojet.entities.Filiere;
import com.moad.miniprojet.services.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/filieres")
public class FiliereController {

    @Autowired
    private FiliereService filiereService;

    @GetMapping
    public String listFilieres(Model model) {
        model.addAttribute("filieres", filiereService.getAllFilieres());
        return "filieres/list";
    }

    @GetMapping("/add")
    public String addFiliereForm(Model model) {
        model.addAttribute("filiere", new Filiere());
        return "filieres/add";
    }

    @PostMapping("/add")
    public String saveFiliere(@ModelAttribute Filiere filiere) {
        filiereService.saveFiliere(filiere);
        return "redirect:/filieres";
    }

    @GetMapping("/edit/{id}")
    public String editFiliereForm(@PathVariable Long id, Model model) {
        Filiere filiere = filiereService.getFiliereById(id);
        model.addAttribute("filiere", filiere);
        return "filieres/edit";
    }

    @PostMapping("/update")
    public String updateFiliere(@ModelAttribute Filiere filiere) {
        filiereService.saveFiliere(filiere);
        return "redirect:/filieres";
    }

    @GetMapping("/delete/{id}")
    public String deleteFiliere(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (!filiereService.canDelete(id)) {
            redirectAttributes.addFlashAttribute("error", "Impossible de supprimer cette filière car elle contient des élèves ou des cours.");
            return "redirect:/filieres";
        }
        filiereService.deleteFiliere(id);
        redirectAttributes.addFlashAttribute("success", "Filière supprimée avec succès.");
        return "redirect:/filieres";
    }

    @GetMapping("/details/{id}")
    public String detailsFiliere(@PathVariable Long id, Model model) {
        Filiere filiere = filiereService.getFiliereById(id);
        model.addAttribute("filiere", filiere);
        return "filieres/details";
    }
}
