package com.example.MediSage.controller;

import com.example.MediSage.entity.aisummary.AiSummary;
import com.example.MediSage.generic.controller.AbstractController;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.service.IService;
import com.example.MediSage.payload.request.AiSummeryRequestDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("AiSummary")
public class AiSummaryController extends AbstractController<AiSummary, AiSummeryRequestDTO, GenericSearchDto> {
    public AiSummaryController(IService<AiSummary, AiSummeryRequestDTO, GenericSearchDto> service) {
        super(service);
    }
}
