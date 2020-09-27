package com.project.doctolib.controllers;

import com.project.doctolib.models.Patient;
import com.project.doctolib.models.Professionnel;
import com.project.doctolib.services.PatientService;
import com.project.doctolib.services.ProfessionnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PatientController {
    @Autowired
    PatientService patientService;

    // get all Patients
    @GetMapping("/admin/gererPatient")
    public String gererPatient( Model model, @RequestParam(name = "page", defaultValue = "0") int page) {

        // send list users
        model.addAttribute("listUserActive", patientService.getAll( PageRequest.of(page, 10, Sort.by("firstName"))));

        // send current page

        model.addAttribute("currentPage", page);
        return "admin/gererPatient";
    }
    @GetMapping("/admin/gererPatient/delete")
    public String deleteUser(@RequestParam int id) {
        patientService.delete(id);

        return "redirect:/admin/gererPatient";
    }

    @GetMapping("/admin/gererPatient/bloque")
    public String bloquerUser(@RequestParam int id) {
        Patient user = patientService.getById(id);
       boolean isActive= user.isActive();
        user.setActive(!isActive);
        patientService.add(user);

        return "redirect:/admin/gererPatient";
    }
}
