package com.example.MediSage.service.impl;

import com.example.MediSage.auth.repository.UserRepo;
import com.example.MediSage.config.image.service.CloudneryImageService;
import com.example.MediSage.entity.patients.Patients;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.repository.AbstractRepository;
import com.example.MediSage.generic.service.AbstractService;
import com.example.MediSage.payload.request.PatientsRequestDTO;
import com.example.MediSage.payload.response.PatientsResponseDTO;
import com.example.MediSage.repository.patients.PatientsRepository;
import com.example.MediSage.service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;


@Service
public class PatientsServiceIMPL extends AbstractService<Patients, PatientsRequestDTO, GenericSearchDto> implements PatientsService {

    public PatientsServiceIMPL(AbstractRepository<Patients> repository) {
        super(repository);
    }

    @Autowired
    CloudneryImageService cloudneryImageService;

    @Autowired
    PatientsRepository patientsRepository;

    @Autowired
    UserRepo userRepo;

    @Override
    protected PatientsResponseDTO convertToResponseDto(Patients patients) {
        PatientsResponseDTO dto = new PatientsResponseDTO();
        dto.setFullName(patients.getFullName());
        dto.setHealthGoals(patients.getHealthGoals());
        dto.setDateOfBirth(patients.getDateOfBirth());
        dto.setGender(patients.getGender());
        dto.setWeight(patients.getWeight());
        dto.setHeight(patients.getHeight());
        dto.setEatingHabit(patients.getEatingHabit());
        dto.setMedications(patients.getMedications());
        dto.setMedicalConditions(patients.getMedicalConditions());
        dto.setBloodType(patients.getBloodType());
        dto.setHealthNotes(patients.getHealthNotes());
        return dto;
    }

    @Override
    protected Patients convertToEntity(PatientsRequestDTO dto) throws IOException {
        return updateEntity(dto, new Patients());
    }

    @Override
    protected Patients updateEntity(PatientsRequestDTO dto, Patients entity) throws IOException {
        entity.setFullName(dto.getFullName());
        entity.setHealthGoals(dto.getHealthGoals());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setGender(dto.getGender());
        entity.setWeight(dto.getWeight());
        entity.setHeight(dto.getHeight());
        entity.setEatingHabit(dto.getEatingHabit());
        entity.setMedications(dto.getMedications());
        entity.setMedicalConditions(dto.getMedicalConditions());
        entity.setBloodType(dto.getBloodType());
        entity.setHealthNotes(dto.getHealthNotes());
        entity.setUser(userRepo.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("User not found")));
        return entity;
    }

    @Override
    protected Specification<Patients> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
//
//    public void createPatient(PatientsRequestDTO dto, MultipartFile profilepic) throws IOException {
//        Patients entity = new Patients();
//
//        String profileImageUrl = "https://res.cloudinary.com/dxmwiwy6g/image/upload/v1740298839/jhp0yhawmfwffy195dn8.jpg";
//
//        if (profilepic != null) {
//            Map<String, Object> uploadResult = cloudneryImageService.upload(profilepic);
//            profileImageUrl = (String) uploadResult.get("secure_url");
//        }
//
//        entity.setFullName(dto.getFullName());
//        entity.setHealthGoals(dto.getHealthGoals());
//        entity.setDateOfBirth(dto.getDateOfBirth());
//        entity.setGender(dto.getGender());
//        entity.setWeight(dto.getWeight());
//        entity.setHeight(dto.getHeight());
//        entity.setEatingHabit(dto.getEatingHabit());
//        entity.setMedications(dto.getMedications());
//        entity.setMedicalConditions(dto.getMedicalConditions());
//        entity.setBloodType(dto.getBloodType());
//        entity.setHealthNotes(dto.getHealthNotes());
//        entity.setUser(userRepo.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("User not found")));
//
//        patientsRepository.save(entity);
//    }
}

