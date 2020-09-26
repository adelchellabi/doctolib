package com.project.doctolib.controllers;

import com.project.doctolib.models.MyUserDetails;
import com.project.doctolib.models.User;
import com.project.doctolib.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {


    @Autowired
    UserService userService;




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
        return "admin/index";
    }

    @ResponseBody
    @RequestMapping("/patient/index")
    public String helloP() {
        return "hello patient";
    }


    @GetMapping("/403")
    public String errors() {
        return "403";
    }

}
