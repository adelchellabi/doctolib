package com.project.doctolib.controllers;

import com.project.doctolib.models.MyUserDetails;
import com.project.doctolib.models.Patient;
import com.project.doctolib.models.Professionnel;
import com.project.doctolib.models.User;
import com.project.doctolib.services.PatientService;
import com.project.doctolib.services.ProfessionnelService;
import com.project.doctolib.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {


    @Autowired
    UserService userService;
    @Autowired
    private PatientService patientService;


    @ResponseBody
    @GetMapping("/")
    public String showRegisterForm() {

        return "index";
    }


    @RequestMapping("/admin/index")
    public String helloA(HttpSession session) {

        //get session
        MyUserDetails userPrincipal = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUserByUserName(userPrincipal.getUsername());
        session.setAttribute("user", user);

    /*    Patient p2 = new Patient();
BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        p2.setActive(true);
        p2.setFirstName("patient");
        p2.setLastName("patient");
        p2.setUsername("patient");
        p2.setEmail("patient@gmail.com");
        p2.setPassword(bc.encode("adel96"));
        p2.setRoles("ROLE_PATIENT");
        patientService.add(p2);*/
        return "admin/index";
    }




    @GetMapping("/403")
    public String errors() {
        return "403";
    }

}
