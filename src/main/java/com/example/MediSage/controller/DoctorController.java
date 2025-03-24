package com.example.MediSage.controller;

import com.example.MediSage.entity.doctor.Doctor;
import com.example.MediSage.generic.controller.AbstractController;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.service.IService;
import com.example.MediSage.payload.request.DoctorRequestDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Doctor")
public class DoctorController extends AbstractController<Doctor, DoctorRequestDTO, GenericSearchDto> {
    public DoctorController(IService<Doctor, DoctorRequestDTO, GenericSearchDto> service) {
        super(service);
    }
}
