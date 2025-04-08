package com.example.MediSage.entity.symptoms.service.impl;

import com.example.MediSage.entity.symptoms.entity.Symptoms;
import com.example.MediSage.entity.symptoms.payload.request.SymptomsRequestDto;
import com.example.MediSage.entity.symptoms.repository.SymptomsRepository;
import com.example.MediSage.entity.symptoms.service.SymptomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SymptomServiceImpl implements SymptomsService {

    @Autowired
    private SymptomsRepository symptomsRepository;
    @Override
    public List<Symptoms> findByNameIgnoreCase(String name) {
        return symptomsRepository.findByNameIgnoreCase(name);
    }

    @Override
    public void create(SymptomsRequestDto symptomsRequestDto) {
        Symptoms symptoms = new Symptoms();
        symptoms.setName(symptomsRequestDto.getName());
        symptomsRepository.save(symptoms);
    }
}
