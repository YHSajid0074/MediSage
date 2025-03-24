package com.example.MediSage.controller;

import com.example.MediSage.entity.patients.Patients;
import com.example.MediSage.generic.controller.AbstractController;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.service.IService;
import com.example.MediSage.payload.request.PatientsRequestDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Patient")
public class PatientsController extends AbstractController <Patients, PatientsRequestDTO, GenericSearchDto>{
    public PatientsController(IService<Patients, PatientsRequestDTO, GenericSearchDto> service) {
        super(service);
    }
}
