package nus.iss.ssf_assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import nus.iss.ssf_assessment.dto.Article;
import nus.iss.ssf_assessment.service.ApiFetch;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @Autowired
    private ApiFetch apiFetch;

    @GetMapping
    public String showHome(Model model) {

        String responseBody = apiFetch.rawJsonFetcher();
        List<Article> articles = apiFetch.getArticles(responseBody);

        model.addAttribute("allArticles", articles);
        return "cnotd";

    }
    
    
}
