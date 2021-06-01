package com.project.doctolib.controllers;

import com.project.doctolib.models.*;
import com.project.doctolib.services.*;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
public class ProfessionnelController {
    @Autowired
    ProfessionnelService professionnelService;
    @Autowired
    SpecialiteService specialiteService;
    @Autowired
    UserService userService;
    @Autowired
    FormationService formationService;
    @Autowired
    ExperianceService experianceService;

    @Autowired
    LangueService langueService;

    @GetMapping("/professionnel/index")
    public ModelAndView pagePro(HttpSession session) {

        //get session
        MyUserDetails userPrincipal = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUserByUserName(userPrincipal.getUsername());
        session.setAttribute("user", user);

        ModelAndView modelAndView = new ModelAndView("professionnel/index");
        return modelAndView;
    }

    @GetMapping("professionnel/editProfil")
    public String showeditProfilForm(HttpSession session, Model model) {
        Professionnel user = professionnelService.getById(((User) session.getAttribute("user")).getId());
        model.addAttribute("user", user);
        model.addAttribute("formations", formationService.getAll(user.getId()));
        model.addAttribute("experiances", experianceService.getAll(user.getId()));
        model.addAttribute("langues", langueService.getByIdPro(user.getId()));
        model.addAttribute("allLanguages",langueService.getAll());
        model.addAttribute("formation", new Formation());
        model.addAttribute("experiance", new Experiance());

        List<Integer> years = new ArrayList<>();
        for (int i = 1950; i < 2061; i++)
            years.add(i);
        model.addAttribute("years", years);
        return "professionnel/editProfile";
    }

    // get all professionnels
    @GetMapping("/admin/listProfessionnel")
    public String listPro(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {

        // send list users
        model.addAttribute("listUserActive", professionnelService.getAll(PageRequest.of(page, 10, Sort.by("firstName"))));

        // send current page

        model.addAttribute("currentPage", page);
        return "admin/listPro";
    }


    @GetMapping("/admin/gererPro")
    public String gererPro(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {

        // send list users
        model.addAttribute("listUserActive", professionnelService.getAll(PageRequest.of(page, 10, Sort.by("firstName"))));

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
        boolean isActive = user.isActive();
        user.setActive(!isActive);
        professionnelService.add(user);

        return "redirect:/admin/gererPro";
    }

    // add new professionnel
    @RequestMapping("/admin/addNewPro")
    public String showForm(Model model) {

        Professionnel professionnel = new Professionnel();
        model.addAttribute("professionnel", professionnel);
        model.addAttribute("specialites", specialiteService.getAll());
        return "admin/ajouterPro";
    }

    @PostMapping("/admin/savePro")
    public String addNew(@ModelAttribute("professionnel") @Valid Professionnel user, Errors errors, Model message) {
        boolean usernameExist = userService.getUserByUserName(user.getUsername()) != null;

        if (errors.hasErrors() || usernameExist) {
            if (usernameExist)
                message.addAttribute("usernameExist", "Ce username est déja utilisé !");
            message.addAttribute("specialites", specialiteService.getAll());
            return "admin/ajouterPro";
        }

        user.setActive(true);
        user.setVisible(false);
        user.setRoles("ROLE_PROFESSIONNEL");
        professionnelService.add(user);
        message.addAttribute("result", "You have success fil register.");
        message.addAttribute("specialites", specialiteService.getAll());
        return "admin/ajouterPro";

    }
}
