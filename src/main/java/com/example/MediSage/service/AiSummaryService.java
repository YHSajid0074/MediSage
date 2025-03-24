package com.example.MediSage.service;

import com.example.MediSage.entity.aisummary.AiSummary;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.service.IService;
import com.example.MediSage.payload.request.AiSummeryRequestDTO;

public interface AiSummaryService extends IService<AiSummary, AiSummeryRequestDTO, GenericSearchDto> {
}
