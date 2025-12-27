package com.moad.miniprojet.controllers;

import com.moad.miniprojet.entities.Eleve;
import com.moad.miniprojet.services.CoursService;
import com.moad.miniprojet.services.EleveService;
import com.moad.miniprojet.services.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/eleves")
public class EleveController {

    @Autowired
    private EleveService eleveService;

    @Autowired
    private FiliereService filiereService;

    @Autowired
    private CoursService coursService;

    @GetMapping
    public String listEleves(Model model) {
        model.addAttribute("eleves", eleveService.getAllEleves());
        return "eleves/list";
    }

    @GetMapping("/add")
    public String addEleveForm(Model model) {
        model.addAttribute("eleve", new Eleve());
        model.addAttribute("filieres", filiereService.getAllFilieres());
        return "eleves/add";
    }

    @PostMapping("/add")
    public String saveEleve(@ModelAttribute Eleve eleve) {
        eleveService.saveEleve(eleve);
        return "redirect:/eleves";
    }

    @GetMapping("/edit/{id}")
    public String editEleveForm(@PathVariable Long id, Model model) {
        Eleve eleve = eleveService.getEleveById(id);
        model.addAttribute("eleve", eleve);
        model.addAttribute("filieres", filiereService.getAllFilieres());
        model.addAttribute("coursList", coursService.getAllCours());
        return "eleves/edit";
    }

    @PostMapping("/update")
    public String updateEleve(@ModelAttribute Eleve eleve) {
        eleveService.saveEleve(eleve);
        return "redirect:/eleves";
    }

    @GetMapping("/delete/{id}")
    public String deleteEleve(@PathVariable Long id) {
        eleveService.deleteEleve(id);
        return "redirect:/eleves";
    }

    @GetMapping("/details/{id}")
    public String detailsEleve(@PathVariable Long id, Model model) {
        Eleve eleve = eleveService.getEleveById(id);
        model.addAttribute("eleve", eleve);
        return "eleves/details";
    }
}
