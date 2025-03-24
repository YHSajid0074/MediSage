package com.example.MediSage.service.impl;

import com.example.MediSage.entity.hospital.Hospital;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.payload.response.BaseResponseDto;
import com.example.MediSage.generic.repository.AbstractRepository;
import com.example.MediSage.generic.service.AbstractService;
import com.example.MediSage.payload.request.HospitalRequestDTO;
import com.example.MediSage.service.HospitalService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HospitalServiceIMPL extends AbstractService<Hospital, HospitalRequestDTO, GenericSearchDto> implements HospitalService {
    public HospitalServiceIMPL(AbstractRepository<Hospital> repository) {
        super(repository);
    }

    @Override
    protected <T extends BaseResponseDto> T convertToResponseDto(Hospital hospital) {
        return null;
    }

    @Override
    protected Hospital convertToEntity(HospitalRequestDTO hospitalRequestDTO) throws IOException {
        return null;
    }

    @Override
    protected Hospital updateEntity(HospitalRequestDTO hospitalRequestDTO, Hospital entity) throws IOException {
        return null;
    }

    @Override
    protected Specification<Hospital> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
