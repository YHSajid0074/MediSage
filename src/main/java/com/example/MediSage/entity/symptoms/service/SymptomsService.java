package com.example.MediSage.entity.symptoms.service;

import com.example.MediSage.entity.symptoms.entity.Symptoms;
import com.example.MediSage.entity.symptoms.payload.request.SymptomsRequestDto;

import java.util.List;

public interface SymptomsService {
    List<Symptoms> findByNameIgnoreCase(String name);
    void create(SymptomsRequestDto symptomsRequestDto);
}
