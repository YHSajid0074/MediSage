package com.example.MediSage.service.impl;

import com.example.MediSage.entity.appointment.Appointment;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.payload.response.BaseResponseDto;
import com.example.MediSage.generic.repository.AbstractRepository;
import com.example.MediSage.generic.service.AbstractService;
import com.example.MediSage.payload.request.AppointmentRequestDTO;
import com.example.MediSage.service.AppointmentService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AppointmentServiceIMPL extends AbstractService<Appointment, AppointmentRequestDTO, GenericSearchDto> implements AppointmentService {
    public AppointmentServiceIMPL(AbstractRepository<Appointment> repository) {
        super(repository);
    }

    @Override
    protected <T extends BaseResponseDto> T convertToResponseDto(Appointment appointment) {
        return null;
    }

    @Override
    protected Appointment convertToEntity(AppointmentRequestDTO appointmentRequestDTO) throws IOException {
        return null;
    }

    @Override
    protected Appointment updateEntity(AppointmentRequestDTO appointmentRequestDTO, Appointment entity) throws IOException {
        return null;
    }

    @Override
    protected Specification<Appointment> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
