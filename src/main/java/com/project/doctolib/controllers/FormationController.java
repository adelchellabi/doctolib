package com.project.doctolib.controllers;

import com.project.doctolib.models.*;
import com.project.doctolib.repositories.Langue_professionnelRepository;
import com.project.doctolib.services.FormationService;
import com.project.doctolib.services.ProfessionnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FormationController {
    @Autowired
    FormationService formationService;
    @Autowired
    ProfessionnelService professionnelService;
    @Autowired
    Langue_professionnelRepository langue_professionnelRepository;
    @PostMapping("/professionnel/saveFormation")
    public String save(@ModelAttribute(name = "formation") @Valid Formation formation, Errors errors, HttpSession session) {
        Professionnel user = professionnelService.getById(((User) session.getAttribute("user")).getId());
        formation.setIdProfessionnel(user.getId());
        if (errors.hasErrors()) return "redirect:/professionnel/editProfil";
        formationService.add(formation);
        return "redirect:/professionnel/editProfil";
    }

    @GetMapping("/professionnel/saveLangues")
    public String test(@RequestParam(name = "langue") List<Integer> langue , HttpSession session) {
        List<Langue_professionnel> list = new ArrayList<>();
        Professionnel user = professionnelService.getById(((User) session.getAttribute("user")).getId());
        for (Integer s : langue) {
            list.add(new Langue_professionnel(user.getId(),s));

        }
        langue_professionnelRepository.saveAll(list);
        return "redirect:/professionnel/editProfil";
    }

}
