package com.project.doctolib.controllers;

import com.project.doctolib.models.*;
import com.project.doctolib.repositories.Langue_professionnelRepository;

import com.project.doctolib.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
public class HomeController {


    @Autowired
    UserService userService;



    @ResponseBody
    @GetMapping("/")
    public String showindex() {

        return "index";
    }


    @RequestMapping("/admin/index")
    public String helloA(HttpSession session) {

        //get session
        MyUserDetails userPrincipal = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUserByUserName(userPrincipal.getUsername());
        session.setAttribute("user", user);


        return "admin/index";
    }


    @GetMapping("admin/editProfil")
    public ModelAndView showeditProfilForm(HttpSession session, Model model) {
        User user = userService.getUserById(((User) session.getAttribute("user")).getId());
        ModelAndView mav = new ModelAndView("admin/editProfile");
        mav.addObject("user", user);
        return mav;
    }
    @PostMapping("admin/update")
    public String addNew(@ModelAttribute("user") @Valid User user, Errors errors, Model message) {
        if (errors.hasErrors()) {
            return "admin/editProfile";
        }
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        user.setActive(true);
        user.setPassword(bc.encode(user.getPassword()));
        if (userService.addUser(user)) {
            message.addAttribute("result", "Update successfully.");
        }
        return "admin/editProfile";
    }


    @GetMapping("/403")
    public String errors() {
        return "403";
    }






}
