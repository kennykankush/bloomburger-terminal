package nus.iss.ssf_assessment.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import nus.iss.ssf_assessment.configuration.ApiConfig;
import nus.iss.ssf_assessment.dto.Article;

@Service
public class ApiFetch {

    @Autowired
    private ApiConfig ac;

    public String rawJsonFetcher(){

        RestTemplate restTemplate = new RestTemplate(); 
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Auth-Token", ac.getApiKey());

        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        ResponseEntity<String> response = restTemplate.exchange(ac.getApiURL(), HttpMethod.GET, entity, String.class);

        return response.getBody();

    }

    public List<Article> getArticles(String responseBody){

        List<Article> articles = new ArrayList<>();

        JsonReader jsonReader =  Json.createReader(new StringReader(responseBody));
        JsonObject jsonObject = jsonReader.readObject();
        JsonArray accessingLevel_Data = jsonObject.getJsonArray("Data");

        for (int i = 0; i < accessingLevel_Data.size(); i++){
            JsonObject dataIteration = accessingLevel_Data.getJsonObject(i);

            Article article = new Article();

            article.setBody(dataIteration.getString("body"));
            article.setCategories(dataIteration.getString("categories"));
            article.setId(dataIteration.getString("id"));
            article.setImageurl(dataIteration.getString("imageurl"));

            // long dateConversion = dataIteration.getInt("published_on");
            // LocalDateTime dateTime = Instant.ofEpochSecond(dateConversion)
            //                             .atZone(ZoneId.systemDefault())
            //                             .toLocalDateTime();

            article.setPublished_on(dataIteration.getInt("published_on"));

            // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            // String formattedDate = dateTime.format(formatter);

            article.setTags(dataIteration.getString("tags"));
            article.setTitle(dataIteration.getString("title"));
            article.setUrl(dataIteration.getString("url"));

            articles.add(article);

        }
        
        return articles;

    }

    
}
