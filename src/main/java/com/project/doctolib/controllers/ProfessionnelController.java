package com.project.doctolib.controllers;

import com.project.doctolib.models.Professionnel;
import com.project.doctolib.services.ProfessionnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ProfessionnelController {
    @Autowired
    ProfessionnelService professionnelService;

    // get all professionnels
    @GetMapping("/admin/gererPro")
    public String gererPro( Model model, @RequestParam(name = "page", defaultValue = "0") int page) {

        // send list users
        model.addAttribute("listUserActive", professionnelService.getAll( PageRequest.of(page, 10, Sort.by("firstName"))));

        // send current page

        model.addAttribute("currentPage", page);
        return "admin/gererPro";
    }
    @GetMapping("/admin/gererPro/delete")
    public String deleteUser(@RequestParam int id) {
        professionnelService.delete(id);

        return "redirect:/admin/gererPro";
    }

    @GetMapping("/admin/gererPro/bloque")
    public String bloquerUser(@RequestParam int id) {
        Professionnel user = professionnelService.getById(id);
       boolean isActive= user.isActive();
        user.setActive(!isActive);
        professionnelService.add(user);

        return "redirect:/admin/gererPro";
    }
}
