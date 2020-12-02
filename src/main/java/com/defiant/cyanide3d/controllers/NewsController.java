package com.defiant.cyanide3d.controllers;

import com.defiant.cyanide3d.models.News;
import com.defiant.cyanide3d.services.NewsService;
import com.defiant.cyanide3d.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    NewsService newsService;
    @Autowired
    UserService userService;

    @GetMapping()
    public String news(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
        int factor = 8;
        if (page == 0) {
            return "redirect:/news";
        }
        List<News> allNews = newsService.index();
        allNews.sort(Comparator.comparing(News::getId));
        model.addAttribute("max", allNews.size() % factor == 0 ? allNews.size() / factor : (allNews.size() / factor) + 1);
        model.addAttribute("news", allNews.subList(Math.max(allNews.size() - page * factor, 0), Math.max(allNews.size() - (page - 1) * factor, 0)).stream().sorted(Comparator.comparing(News::getId).reversed()).collect(Collectors.toList()));
        return "news/allnews";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("news", newsService.show(id));
        return "news/show";
    }

    @GetMapping("/new")
    public String newWow(Model model) {
        model.addAttribute("news", new News());
        return "news/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("news") News news) {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        newsService.save(news, user.getUsername());
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("news", newsService.edit(id));
        return "news/edit";
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.PATCH, RequestMethod.POST})
    public String update(@ModelAttribute("news") News news, @PathVariable("id") int id) {
        newsService.update(id, news);
        return "redirect:/news/" + id;
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        newsService.delete(id);
        return "redirect:/";
    }
}