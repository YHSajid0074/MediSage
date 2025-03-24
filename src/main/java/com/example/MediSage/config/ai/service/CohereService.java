package com.example.MediSage.config.ai.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CohereService {

    @Value("${cohere.api.key}")
    private String cohereApiKey;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public CohereService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public String askCreator(String question) {
        String response = "I'm not sure how to answer that.";

        // List of creator-related questions
        String[] creatorKeywords = {
                "who is your creator",
                "who created you",
                "who are you made by",
                "who is the developer",
                "who is the owner"
        };

        // Check if the question contains any of the creator-related keywords
        for (String keyword : creatorKeywords) {
            if (question.toLowerCase().contains(keyword)) {
                response = "I am developed by Yeamim Hossain Sajid and Md Sifat Bin Jibon. They both are currently studying at United International University.";
                return response;
            }
        }

        // If no creator-related keyword is found, use the API to generate a response
        if (response.equals("I'm not sure how to answer that.")) {
            try {
                String url = "https://api.cohere.ai/v1/generate";
                HttpHeaders headers = new HttpHeaders();
                headers.set("Authorization", "Bearer " + cohereApiKey);
                headers.set("Content-Type", "application/json");

                // Build the request body using ObjectMapper
                ObjectNode requestBody = objectMapper.createObjectNode();
                requestBody.put("prompt", question);
                requestBody.put("max_tokens", 250);
                requestBody.put("temperature", 0.7);

                HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(requestBody), headers);
                ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

                // Check if we received a valid response from the API
                if (responseEntity.getBody() != null) {
                    JsonNode responseJson = objectMapper.readTree(responseEntity.getBody());
                    // Debug log: Print the raw API response
                    System.out.println("API Response: " + responseEntity.getBody());

                    // Safeguard: Check if "generations" is not null and has elements
                    JsonNode generationsNode = responseJson.path("generations");
                    if (generationsNode.isArray() && generationsNode.size() > 0) {
                        response = generationsNode.get(0).path("text").asText("No response from Cohere API.");
                    } else {
                        response = "No valid response from Cohere API.";
                    }
                } else {
                    response = "No response from API.";
                }
            } catch (Exception e) {
                response = "An error occurred while processing your request: " + e.getMessage();
            }
        }

        return response;
    }


}
