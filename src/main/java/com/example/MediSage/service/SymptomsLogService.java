package com.example.MediSage.service;

import com.example.MediSage.entity.symptomlog.SymptomLogs;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.service.IService;
import com.example.MediSage.payload.request.SymptomsLogRequestDTO;

public interface SymptomsLogService extends IService<SymptomLogs, SymptomsLogRequestDTO,GenericSearchDto> {
}
