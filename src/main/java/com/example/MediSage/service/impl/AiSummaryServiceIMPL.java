package com.example.MediSage.service.impl;

import com.example.MediSage.entity.aisummary.AiSummary;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.payload.response.BaseResponseDto;
import com.example.MediSage.generic.repository.AbstractRepository;
import com.example.MediSage.generic.service.AbstractService;
import com.example.MediSage.payload.request.AiSummeryRequestDTO;
import com.example.MediSage.payload.response.AiSummeryResponseDTO;
import com.example.MediSage.repository.patients.PatientsRepository;
import com.example.MediSage.service.AiSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AiSummaryServiceIMPL extends AbstractService<AiSummary, AiSummeryRequestDTO, GenericSearchDto> implements AiSummaryService {

    @Autowired
    PatientsRepository patientsRepository;

    public AiSummaryServiceIMPL(AbstractRepository<AiSummary> repository) {
        super(repository);
    }

    @Override
    protected AiSummeryResponseDTO convertToResponseDto(AiSummary aiSummary) {
        AiSummeryResponseDTO responseDto = new AiSummeryResponseDTO();
        responseDto.setSummaryText(aiSummary.getSummaryText());
        responseDto.setPatient(aiSummary.getPatient());
        return responseDto;
    }

    @Override
    protected AiSummary convertToEntity(AiSummeryRequestDTO aiSummeryRequestDTO) throws IOException {
        return updateEntity(aiSummeryRequestDTO, new AiSummary());
    }

    @Override
    protected AiSummary updateEntity(AiSummeryRequestDTO aiSummeryRequestDTO, AiSummary entity) throws IOException {

        entity.setSummaryText(aiSummeryRequestDTO.getSummaryText());
        entity.setPatient(patientsRepository.findById(aiSummeryRequestDTO.getPatientId()).get());

        return entity;
    }

    @Override
    protected Specification<AiSummary> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
