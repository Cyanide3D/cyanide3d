package com.defiant.cyanide3d.controllers;

import com.defiant.cyanide3d.models.User;
import com.defiant.cyanide3d.services.UserService;
import cyanide3d.msg.ChannelModel;
import cyanide3d.msg.MessageProperties;
import cyanide3d.msg.SendMessage;
import cyanide3d.msg.UserStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/discord")
public class DiscordController {
    @Autowired
    UserService userService;

    @GetMapping("/leaderboard")
    public String leaderboard(Model model) throws IOException, ClassNotFoundException {
        List<UserStats> users = (List<UserStats>) new SendMessage().send("leaderboard");
        users.stream().sorted(Comparator.comparing(UserStats::getLevel).thenComparing(UserStats::getExp));
        model.addAttribute("leaders", users);
        return "discord/leaderboard";
    }

    @GetMapping("/message")
    public String message(Model model) throws IOException, ClassNotFoundException {
        model.addAttribute("channels",new SendMessage().send("channels"));
        model.addAttribute("check", new ChannelModel());
        model.addAttribute("message", new MessageProperties());
        return "discord/message";
    }

    @PostMapping("/message")
    public String check(@ModelAttribute("check") ChannelModel channel, @ModelAttribute("message") MessageProperties message) throws IOException, ClassNotFoundException {
        User user = userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        String username;
        if (user == null || "on".equals(message.getAnonymous())){
            username = "Anonymous";
        } else {
            username = user.getNameuser();
        }
        new SendMessage().send(channel.getId() + ":" + username + ":" + message.getMessage());
        return "redirect:/discord/message";
    }
}
