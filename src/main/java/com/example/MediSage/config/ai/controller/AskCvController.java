package com.example.MediSage.config.ai.controller;

import com.example.MediSage.config.ai.service.AskCvService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ai")
public class AskCvController {
    AskCvService askCvService;
    public AskCvController(AskCvService askCvService) {
        this.askCvService = askCvService;
    }
    @GetMapping("cv/question/{id}/{text}")
    public ResponseEntity<String> askCv(@PathVariable Long id,@PathVariable String text) {
        return ResponseEntity.ok(askCvService.askCv(id, text));
    }
}
