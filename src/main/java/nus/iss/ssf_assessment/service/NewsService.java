package nus.iss.ssf_assessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nus.iss.ssf_assessment.dto.Article;
import nus.iss.ssf_assessment.repository.NewsRepository;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public void saveArticles(List<String> selectedArticlesIds){
        newsRepository.saveArticles(selectedArticlesIds);
    }

    public List<Article> fetchedSavedArticles(){
        return newsRepository.fetchSavedArticle();
    }

    public Article getArticlebyId(String id){
        return newsRepository.getArticlebyId(id);
    }

}