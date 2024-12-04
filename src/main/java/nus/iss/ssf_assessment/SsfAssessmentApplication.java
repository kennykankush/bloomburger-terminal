package nus.iss.ssf_assessment;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class SsfAssessmentApplication {

	public static void main(String[] args) throws IOException {

		// NewsService ns = new NewsService();
		// String articles = ns.getArticles(ns.rawJsonFetcher()).toString();

		// File directory = new File(".//src//main//resources", "jsonResult");

        // if (directory.exists()) {
        //     System.out.println("jsonResult directory exist.");
        // } else {
        //     directory.mkdir();
        // }

        // File file = new File(directory, "jsonResult.txt");

        // FileOutputStream fos = new FileOutputStream(file);
        // byte[] jsonByte = articles.getBytes();
        // fos.write(jsonByte);

		SpringApplication.run(SsfAssessmentApplication.class, args);

	}

}
