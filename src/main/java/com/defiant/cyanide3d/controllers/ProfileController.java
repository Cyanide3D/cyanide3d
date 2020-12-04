package com.defiant.cyanide3d.controllers;

import com.defiant.cyanide3d.models.ProfileProperties;
import com.defiant.cyanide3d.models.User;
import com.defiant.cyanide3d.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping()
    public String profile(Model model, @RequestParam(value = "edit", defaultValue = "none") String edit){
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User member = userService.findUserByUsername(user.getUsername());
        model.addAttribute("user", member);
        model.addAttribute("misc", new ProfileProperties());
        if ("profile".equals(edit)){
            return "profile/settings";
        } else if ("password".equals(edit)){
            return "profile/password";
        }
        return "profile/profile";
    }

    @PostMapping()
    public String updateProfile(@ModelAttribute("user") User member, @ModelAttribute("misc") ProfileProperties profileProperties){
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (profileProperties.getOldPassword() != null){
            if (!passwordEncoder.matches(profileProperties.getOldPassword(), user.getPassword())) {
                return "redirect:/profile";
            }
        }
        member.setUsername(user.getUsername());
        userService.update(member);
        return "redirect:/profile";
    }
}
