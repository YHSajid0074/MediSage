package com.example.MediSage.entity.manualsymptomcheck.service.impl;

import com.example.MediSage.entity.manualsymptomcheck.dto.request.ManualSymptomsCheckRequestDTO;
import com.example.MediSage.entity.manualsymptomcheck.dto.response.ManualSymptomsCheckResponseDTO;
import com.example.MediSage.entity.manualsymptomcheck.entity.ManualSymptomsCheck;
import com.example.MediSage.entity.manualsymptomcheck.service.ManualSymptomsCheckService;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.payload.response.BaseResponseDto;
import com.example.MediSage.generic.repository.AbstractRepository;
import com.example.MediSage.generic.service.AbstractService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ManualSymptomsCheckServiceIMPL extends AbstractService<ManualSymptomsCheck, ManualSymptomsCheckRequestDTO, GenericSearchDto> implements ManualSymptomsCheckService {

    public ManualSymptomsCheckServiceIMPL(AbstractRepository<ManualSymptomsCheck> repository) {
        super(repository);
    }

    @Override
    protected ManualSymptomsCheckResponseDTO convertToResponseDto(ManualSymptomsCheck manualSymptomsCheck) {
        ManualSymptomsCheckResponseDTO responseDto = new ManualSymptomsCheckResponseDTO();
        responseDto.setId(manualSymptomsCheck.getId());
        responseDto.setCurrentMedication(manualSymptomsCheck.getCurrentMedication());
        responseDto.setPastCondition(manualSymptomsCheck.getPastCondition());
        responseDto.setAdditionalNotes(manualSymptomsCheck.getAdditionalNotes());
        responseDto.setPainLevel(manualSymptomsCheck.getPainLevel());
        responseDto.setSymptomStartDate(manualSymptomsCheck.getSymptomStartDate());
        responseDto.setSymptomsBother(manualSymptomsCheck.getSymptomsBother());
        return responseDto;
    }

    @Override
    protected ManualSymptomsCheck convertToEntity(ManualSymptomsCheckRequestDTO manualSymptomsCheckRequestDTO) throws IOException {
        return updateEntity(manualSymptomsCheckRequestDTO, new ManualSymptomsCheck());
    }

    @Override
    protected ManualSymptomsCheck updateEntity(ManualSymptomsCheckRequestDTO manualSymptomsCheckRequestDTO, ManualSymptomsCheck entity) throws IOException {
       entity.setCurrentMedication(manualSymptomsCheckRequestDTO.getCurrentMedication());
       entity.setPastCondition(manualSymptomsCheckRequestDTO.getPastCondition());
       entity.setAdditionalNotes(manualSymptomsCheckRequestDTO.getAdditionalNotes());
       entity.setPainLevel(manualSymptomsCheckRequestDTO.getPainLevel());
       entity.setSymptomStartDate(manualSymptomsCheckRequestDTO.getSymptomStartDate());
       entity.setSymptomsBother(manualSymptomsCheckRequestDTO.getSymptomsBother());
       return entity;
    }

    @Override
    protected Specification<ManualSymptomsCheck> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
