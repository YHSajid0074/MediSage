package com.example.MediSage.service.impl;

import com.example.MediSage.entity.patients.Patients;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.payload.response.BaseResponseDto;
import com.example.MediSage.generic.repository.AbstractRepository;
import com.example.MediSage.generic.service.AbstractService;
import com.example.MediSage.payload.request.PatientsRequestDTO;
import com.example.MediSage.service.PatientsService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PatientsServiceIMPL extends AbstractService<Patients, PatientsRequestDTO, GenericSearchDto> implements PatientsService {
    public PatientsServiceIMPL(AbstractRepository<Patients> repository) {
        super(repository);
    }

    @Override
    protected <T extends BaseResponseDto> T convertToResponseDto(Patients patients) {
        return null;
    }

    @Override
    protected Patients convertToEntity(PatientsRequestDTO patientsRequestDTO) throws IOException {
        return null;
    }

    @Override
    protected Patients updateEntity(PatientsRequestDTO patientsRequestDTO, Patients entity) throws IOException {
        return null;
    }

    @Override
    protected Specification<Patients> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
