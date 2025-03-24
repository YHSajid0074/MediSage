package com.example.MediSage.config.ai.controller;//package com.example.ChakriHub.config.ai.controller;
//
////import com.example.ChakriHub.config.ai.service.OpenRouterService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class OpenRouterController {
//
////    private final OpenRouterService openRouterService;
//
//    @Autowired
//    public OpenRouterController(OpenRouterService openRouterService) {
//        this.openRouterService = openRouterService;
//    }
//
//    @GetMapping("/fetch-data")
//    public String fetchData(@RequestParam(required = false, defaultValue = "Your default prompt") String prompt) {
//        return openRouterService.getChatCompletion(prompt);
//    }
//}
