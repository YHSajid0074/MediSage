package com.example.MediSage.config.swagger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    @GetMapping("/healthcheck")
    public String healthCheck() {
        return "OK";
    }
}
