package com.example.MediSage.service.impl;

import com.example.MediSage.entity.aisummary.AiSummary;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.payload.response.BaseResponseDto;
import com.example.MediSage.generic.repository.AbstractRepository;
import com.example.MediSage.generic.service.AbstractService;
import com.example.MediSage.payload.request.AiSummeryRequestDTO;
import com.example.MediSage.service.AiSummaryService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AiSummaryServiceIMPL extends AbstractService<AiSummary, AiSummeryRequestDTO, GenericSearchDto> implements AiSummaryService {
    public AiSummaryServiceIMPL(AbstractRepository<AiSummary> repository) {
        super(repository);
    }

    @Override
    protected <T extends BaseResponseDto> T convertToResponseDto(AiSummary aiSummary) {
        return null;
    }

    @Override
    protected AiSummary convertToEntity(AiSummeryRequestDTO aiSummeryRequestDTO) throws IOException {
        return null;
    }

    @Override
    protected AiSummary updateEntity(AiSummeryRequestDTO aiSummeryRequestDTO, AiSummary entity) throws IOException {
        return null;
    }

    @Override
    protected Specification<AiSummary> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
