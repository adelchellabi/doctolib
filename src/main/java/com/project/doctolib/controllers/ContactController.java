package com.project.doctolib.controllers;

import com.project.doctolib.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {
    @Autowired
    ContactService contactService;

    // consulter les demandes Adhesions
    @RequestMapping("/admin/demandeAdhesion")
    public String showAllContact(Model model,@RequestParam(name = "page", defaultValue = "0") int page){
        model.addAttribute("contacts",contactService.allContact(PageRequest.of(page,10)));
       model.addAttribute("currentPage",page);
        return "admin/contact" ;
    }
}
