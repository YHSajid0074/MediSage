package com.example.MediSage.service.impl;

import com.example.MediSage.entity.doctor.Doctor;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.repository.AbstractRepository;
import com.example.MediSage.generic.service.AbstractService;
import com.example.MediSage.payload.request.DoctorRequestDTO;
import com.example.MediSage.payload.response.DoctorResponseDTO;
import com.example.MediSage.service.DoctorService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DoctorServiceIMPL extends AbstractService<Doctor, DoctorRequestDTO, GenericSearchDto> implements DoctorService {
    public DoctorServiceIMPL(AbstractRepository<Doctor> repository) {
        super(repository);
    }

    @Override
    protected DoctorResponseDTO convertToResponseDto(Doctor doctor) {
        DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO();
        doctorResponseDTO.setAchievements(doctor.getAchievements());
        doctorResponseDTO.setAchievements(doctor.getAchievements());
        return doctorResponseDTO;
    }

    @Override
    protected Doctor convertToEntity(DoctorRequestDTO doctorRequestDTO) throws IOException {
        return updateEntity(doctorRequestDTO, new Doctor());
    }

    @Override
    protected Doctor updateEntity(DoctorRequestDTO doctorRequestDTO, Doctor entity) throws IOException {
        entity.setAchievements(doctorRequestDTO.getAchievements());
        entity.setAchievements(doctorRequestDTO.getAchievements());
        return entity;
    }

    @Override
    protected Specification<Doctor> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
