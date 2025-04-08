package com.example.MediSage.entity.symptoms.controller;

import com.example.MediSage.entity.symptoms.entity.Symptoms;
import com.example.MediSage.entity.symptoms.payload.request.SymptomsRequestDto;
import com.example.MediSage.entity.symptoms.repository.SymptomsRepository;
import com.example.MediSage.entity.symptoms.service.SymptomsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("Symptoms")
@RestController
public class SymptomsController {
    private SymptomsService symptomsService;

    public SymptomsController(SymptomsService symptomsService) {
        this.symptomsService = symptomsService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Symptoms>> findByName(@PathVariable String name) {
        List<Symptoms> symptoms = symptomsService.findByNameIgnoreCase(name);
        return ResponseEntity.ok(symptoms);
    }

    @PostMapping("create")
    public ResponseEntity<String>create(SymptomsRequestDto symptomsRequestDto) {
        symptomsService.create(symptomsRequestDto);
        return ResponseEntity.ok("Symptoms created");
    }
}
