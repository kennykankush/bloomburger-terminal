package nus.iss.ssf_assessment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    private String id;
    private long published_on;
    private String title;
    private String url;
    private String imageurl;
    private String body;
    private String tags;
    private String categories;

    @Override
    public String toString() {
        return "Article{" +
                "id='" + getId() + ", published_on=" + getPublished_on() + ", title='" + getTitle() + ", url='" + getUrl() +
                ", imageurl='" + getImageurl() + ", body='" + getBody() + ", tags='" + getTags()+ ", categories='" + getCategories()+
                '}';
    }

}
