package nus.iss.ssf_assessment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import nus.iss.ssf_assessment.dto.Article;
import nus.iss.ssf_assessment.service.NewsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/news")
public class NewsRestController {

    @Autowired
    private NewsService ns;
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> idArticleREST(@PathVariable String id) {

        Article article = ns.getArticlebyId(id);

        if (article == null) {
            String errorMessage = "{\"error\": \"Cannot find news article " + id + "\"}";
    
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(errorMessage);
        }

        // JsonObject json = Json.createObjectBuilder()
        // .add("id", article.getId())
        // .add("title", article.getTitle())
        // .add("body", article.getBody())
        // .add("published_on", article.getPublished_on())
        // .add("url", article.getUrl())
        // .add("imageurl", article.getImageurl())
        // .add("tags", article.getUrl())
        // .add("categories", article.getCategories()).build();

        return ResponseEntity.ok(article);

    }

    
}
