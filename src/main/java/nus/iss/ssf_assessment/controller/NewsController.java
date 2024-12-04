package nus.iss.ssf_assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import nus.iss.ssf_assessment.dto.Article;
import nus.iss.ssf_assessment.service.NewsService;


@Controller
public class NewsController {

    @Autowired
    private NewsService ns;

    @PostMapping("/articles")
    public String saveArticles(@RequestParam("selected") List<String> selectedIds){

        ns.saveArticles(selectedIds);

        return "redirect:/showSavedArticles";
    }

    @GetMapping("/showSavedArticles")
    public String showSavedArticles(Model model){

        List<Article> articles = ns.fetchedSavedArticles();

        model.addAttribute("allSavedArticles", articles);

        return "savedarticles";
    }

}

