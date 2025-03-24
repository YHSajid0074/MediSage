package com.example.MediSage.config.ai.service;//package com.example.ChakriHub.config.ai.service;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//public class OpenRouterService {
//
//    @Value("${openrouter.api.key}")
//    private String openRouterApiKey;
//
//    private final RestTemplate restTemplate;
//    private final ObjectMapper objectMapper;
//
//    public OpenRouterService(RestTemplate restTemplate, ObjectMapper objectMapper) {
//        this.restTemplate = restTemplate;
//        this.objectMapper = objectMapper;
//    }
//
//    public String getChatCompletion(String userMessage) {
//        String response;
//
//        try {
//            String url = "https://openrouter.ai/api/v1/chat/completions";
//            HttpHeaders headers = new HttpHeaders();
//            headers.set("Authorization", "Bearer " + openRouterApiKey);
//            headers.set("Content-Type", "application/json");
//            headers.set("HTTP-Referer", "https://chakrihub-x0bd.onrender.com"); // Optional
//            headers.set("X-Title", "ChakriHub"); // Optional
//
//            // Construct the request body
//            String requestBody = String.format(
//                    "{\"model\": \"openai/gpt-3.5-turbo-0613\", \"messages\": [{\"role\": \"user\", \"content\": \"%s\"}]}",
//                    userMessage
//            );
//
//            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
//
//            // Log request details
//            System.out.println("Request URL: " + url);
//            System.out.println("Request Headers: " + headers);
//            System.out.println("Request Body: " + requestBody);
//
//            // Make the API call
//            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
//
//            // Log the response status and body
//            System.out.println("Response Status: " + responseEntity.getStatusCode());
//            System.out.println("Response Body: " + responseEntity.getBody());
//
//            if (responseEntity.getBody() != null) {
//                JsonNode responseJson = objectMapper.readTree(responseEntity.getBody());
//                response = responseJson.path("choices").get(0).path("message").path("content").asText("No response from API.");
//            } else {
//                response = "No response from API.";
//                System.out.println("Response body was null");
//            }
//        } catch (Exception e) {
//            response = "An error occurred while processing your request: " + e.getMessage();
//            e.printStackTrace(); // Log the stack trace for debugging
//        }
//
//        return response;
//    }
//}
