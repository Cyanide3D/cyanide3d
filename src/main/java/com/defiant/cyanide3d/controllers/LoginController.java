package com.defiant.cyanide3d.controllers;

import com.defiant.cyanide3d.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping()
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login/form";
    }
}
