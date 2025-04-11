package com.example.MediSage.entity.manualsymptomcheck.controller;

import com.example.MediSage.entity.manualsymptomcheck.dto.request.ManualSymptomsCheckRequestDTO;
import com.example.MediSage.entity.manualsymptomcheck.dto.response.ManualSymptomsCheckResponseDTO;
import com.example.MediSage.entity.manualsymptomcheck.entity.ManualSymptomsCheck;
import com.example.MediSage.generic.controller.AbstractController;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.service.IService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("manual-symptomschecker")
public class ManualSymptomsCheckController extends AbstractController<ManualSymptomsCheck, ManualSymptomsCheckRequestDTO, GenericSearchDto> {

    public ManualSymptomsCheckController(IService<ManualSymptomsCheck, ManualSymptomsCheckRequestDTO, GenericSearchDto> service) {
        super(service);
    }
}
