package com.moad.miniprojet.controllers;

import com.moad.miniprojet.entities.Cours;
import com.moad.miniprojet.services.CoursService;
import com.moad.miniprojet.services.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cours")
public class CoursController {

    @Autowired
    private CoursService coursService;

    @Autowired
    private FiliereService filiereService;

    @GetMapping
    public String listCours(Model model) {
        model.addAttribute("coursList", coursService.getAllCours());
        return "cours/list";
    }

    @GetMapping("/add")
    public String addCoursForm(Model model) {
        model.addAttribute("cours", new Cours());
        model.addAttribute("filieres", filiereService.getAllFilieres());
        return "cours/add";
    }

    @PostMapping("/add")
    public String saveCours(@ModelAttribute Cours cours) {
        coursService.saveCours(cours);
        return "redirect:/cours";
    }

    @GetMapping("/edit/{id}")
    public String editCoursForm(@PathVariable Long id, Model model) {
        Cours cours = coursService.getCoursById(id);
        model.addAttribute("cours", cours);
        model.addAttribute("filieres", filiereService.getAllFilieres());
        return "cours/edit";
    }

    @PostMapping("/update")
    public String updateCours(@ModelAttribute Cours cours) {
        coursService.saveCours(cours);
        return "redirect:/cours";
    }

    @GetMapping("/delete/{id}")
    public String deleteCours(@PathVariable Long id) {
        coursService.deleteCours(id);
        return "redirect:/cours";
    }
}
