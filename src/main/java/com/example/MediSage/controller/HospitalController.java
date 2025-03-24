package com.example.MediSage.controller;

import com.example.MediSage.entity.hospital.Hospital;
import com.example.MediSage.generic.controller.AbstractController;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.service.IService;
import com.example.MediSage.payload.request.HospitalRequestDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Hospital")
public class HospitalController extends AbstractController<Hospital, HospitalRequestDTO, GenericSearchDto> {
    public HospitalController(IService<Hospital, HospitalRequestDTO, GenericSearchDto> service) {
        super(service);
    }
}
