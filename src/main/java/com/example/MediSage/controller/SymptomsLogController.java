package com.example.MediSage.controller;

import com.example.MediSage.entity.symptomlog.SymptomLogs;
import com.example.MediSage.generic.controller.AbstractController;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.service.IService;
import com.example.MediSage.payload.request.SymptomsLogRequestDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("SymptomsLog")
@RestController
public class SymptomsLogController extends AbstractController<SymptomLogs, SymptomsLogRequestDTO, GenericSearchDto> {
    public SymptomsLogController(IService<SymptomLogs, SymptomsLogRequestDTO, GenericSearchDto> service) {
        super(service);
    }
}
