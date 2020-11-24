package com.defiant.cyanide3d.controllers;

import com.defiant.cyanide3d.dao.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    NewsDao newsDao;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("news", newsDao.index());
        return "index";
    }
}
