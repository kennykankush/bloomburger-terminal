package nus.iss.ssf_assessment.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Value("${crypto.apiKey}")
    private String apiKey;

    @Value("${crypto.apiUrl}")
    private String apiURL;

    public String getApiKey() {
        return apiKey;
    }

    public String getApiURL() {
        return apiURL;
    }

}
