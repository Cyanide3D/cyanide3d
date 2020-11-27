package com.defiant.cyanide3d.controllers;

import com.defiant.cyanide3d.models.User;
import com.defiant.cyanide3d.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping()
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }

    @GetMapping("/registration")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "login/reg";
    }

    @PostMapping("/registration")
    public String save(@ModelAttribute("user") User user) {
        if (userService.loadUserByUsername(user.getUsername()).getUsername().equalsIgnoreCase(user.getUsername())) {
            return "redirect:/registration?error";
        }
        userService.save(user);
        return "redirect:/";
    }
}
