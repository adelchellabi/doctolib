package com.project.doctolib.controllers;

import com.project.doctolib.models.Experiance;
import com.project.doctolib.models.Professionnel;
import com.project.doctolib.models.User;
import com.project.doctolib.services.ExperianceService;
import com.project.doctolib.services.ProfessionnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class ExperianceController {
    @Autowired
    ExperianceService experianceService;
    @Autowired
    ProfessionnelService professionnelService;

    @PostMapping("/professionnel/saveExperience")
    public String save(@ModelAttribute(name = "experiance") @Valid Experiance experiance, Errors errors, HttpSession session) {
        Professionnel user = professionnelService.getById(((User) session.getAttribute("user")).getId());
        experiance.setIdProfessionnel(user.getId());
        if (errors.hasErrors()) return "redirect:/professionnel/editProfil";

        experianceService.add(experiance);
        return "redirect:/professionnel/editProfil";
    }
}
