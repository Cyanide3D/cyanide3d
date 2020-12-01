package com.defiant.cyanide3d.controllers;

import com.defiant.cyanide3d.models.News;
import com.defiant.cyanide3d.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    NewsService newsService;

    @GetMapping()
    public String index(Model model) {
        int index;
        List<News> allNews = newsService.index();
        allNews.sort(Comparator.comparing(News::getId).reversed());
        List<News> lastNews = new ArrayList<>();
        if (allNews.size() < 5){
            index = allNews.size();
        } else {
            index = 5;
        }
        for (int i = 0; i < index; i++) {
            lastNews.add(allNews.get(i));
        }
        model.addAttribute("news", lastNews);
        return "index";
    }
}
