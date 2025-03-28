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
        doctorResponseDTO.setCertifications(doctor.getCertifications());
       doctorResponseDTO.setName(doctor.getName());
       doctorResponseDTO.setPhone(doctor.getPhone());
       doctorResponseDTO.setPicture(doctor.getPicture());
       doctorResponseDTO.setSpecialization(doctor.getSpecialization());
       doctorResponseDTO.setEmail(doctor.getEmail());
       doctorResponseDTO.setId(doctor.getId());
        return doctorResponseDTO;
    }

    @Override
    protected Doctor convertToEntity(DoctorRequestDTO doctorRequestDTO) throws IOException {
        return updateEntity(doctorRequestDTO, new Doctor());
    }

    @Override
    protected Doctor updateEntity(DoctorRequestDTO doctorRequestDTO, Doctor entity) throws IOException {
        entity.setAchievements(doctorRequestDTO.getAchievements());
        entity.setCertifications(doctorRequestDTO.getCertifications());
        entity.setName(doctorRequestDTO.getName());
        entity.setPhone(doctorRequestDTO.getPhone());
        entity.setSpecialization(doctorRequestDTO.getSpecialization());
        entity.setEmail(doctorRequestDTO.getEmail());
        return entity;
    }

    @Override
    protected Specification<Doctor> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
