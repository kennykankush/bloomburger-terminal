package nus.iss.ssf_assessment.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import nus.iss.ssf_assessment.dto.Article;
import nus.iss.ssf_assessment.service.ApiFetch;

@Repository
public class NewsRepository {

    @Autowired
    @Qualifier("jsonTemplate")
    private RedisTemplate<String,Object> template;

    @Autowired
    private ApiFetch apiFetch;

    private String hash = "savedArticles";

    public void saveArticles(List<String> selectedArticlesIds){

        List<Article> articles = apiFetch.getArticles(apiFetch.rawJsonFetcher());
        Article article = new Article();

        for (int i = 0; i < articles.size(); i++){
            for (int j = 0; j < selectedArticlesIds.size(); j++){

                if (articles.get(i).getId().equals(selectedArticlesIds.get(j))){

                    article = articles.get(i);

                    template.opsForHash().put(hash, article.getId(), article);

                }
            }


        }
    }

    public List<Article> fetchSavedArticle(){

        List<Article> articles = new ArrayList<>();

        List<Object> rawArticles = template.opsForHash().values(hash);

        for (Object obj : rawArticles) {
            articles.add((Article) obj);
        }

        return articles;

    }

    public Article getArticlebyId(String id){
        Article article = (Article) template.opsForHash().get(hash, id);

        return article;
    }
    
    
}
