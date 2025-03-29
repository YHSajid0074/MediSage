package com.example.MediSage.service.impl;

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


    @Override
    protected PatientsResponseDTO convertToResponseDto(Patients patients) {

        PatientsResponseDTO patientsResponseDTO = new PatientsResponseDTO();
        patientsResponseDTO.setAddress(patients.getAddress());
        patientsResponseDTO.setFirstName(patients.getFirstName());
        patientsResponseDTO.setLastName(patients.getLastName());
        patientsResponseDTO.setEmail(patients.getEmail());
        patientsResponseDTO.setPhone(patients.getPhone());
        patientsResponseDTO.setCity(patients.getCity());
        patientsResponseDTO.setState(patients.getState());
        patientsResponseDTO.setZipCode(patients.getZipCode());
        patientsResponseDTO.setGender(patients.getGender());
        patientsResponseDTO.setDateOfBirth(patients.getDateOfBirth());
        patientsResponseDTO.setAllergies(patients.getAllergies());
        patientsResponseDTO.setCountry(patients.getCountry());
        patientsResponseDTO.setBloodType(patients.getBloodType());
        patientsResponseDTO.setMedicalHistory(patients.getMedicalHistory());
        patientsResponseDTO.setPicture(patients.getPicture());
        return patientsResponseDTO;
    }

    @Override
    protected Patients convertToEntity(PatientsRequestDTO patientsRequestDTO) throws IOException {
        return updateEntity(patientsRequestDTO,new Patients());
    }

    @Override
    protected Patients updateEntity(PatientsRequestDTO patientsRequestDTO, Patients entity) throws IOException {
        entity.setAddress(patientsRequestDTO.getAddress());
        entity.setFirstName(patientsRequestDTO.getFirstName());
        entity.setLastName(patientsRequestDTO.getLastName());
        entity.setEmail(patientsRequestDTO.getEmail());
        entity.setPhone(patientsRequestDTO.getPhone());
        entity.setCity(patientsRequestDTO.getCity());
        entity.setState(patientsRequestDTO.getState());
        entity.setZipCode(patientsRequestDTO.getZipCode());
        entity.setGender(patientsRequestDTO.getGender());
        entity.setDateOfBirth(patientsRequestDTO.getDateOfBirth());
        entity.setAllergies(patientsRequestDTO.getAllergies());
        entity.setCountry(patientsRequestDTO.getCountry());
        entity.setBloodType(patientsRequestDTO.getBloodType());
        entity.setMedicalHistory(patientsRequestDTO.getMedicalHistory());
        return entity;
    }

    @Override
    protected Specification<Patients> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }


    public void createPatient(PatientsRequestDTO patientsRequestDTO, MultipartFile profilepic) throws IOException {

        Patients entity = new Patients();

        String profileImageUrl = "https://res.cloudinary.com/dxmwiwy6g/image/upload/v1740298839/jhp0yhawmfwffy195dn8.jpg";

        if (profilepic != null) {
            Map<String, Object> heroUploadResult = cloudneryImageService.upload(profilepic);
            profileImageUrl = (String) heroUploadResult.get("secure_url");
        }
        entity.setAddress(patientsRequestDTO.getAddress());
        entity.setFirstName(patientsRequestDTO.getFirstName());
        entity.setLastName(patientsRequestDTO.getLastName());
        entity.setEmail(patientsRequestDTO.getEmail());
        entity.setPhone(patientsRequestDTO.getPhone());
        entity.setCity(patientsRequestDTO.getCity());
        entity.setState(patientsRequestDTO.getState());
        entity.setZipCode(patientsRequestDTO.getZipCode());
        entity.setGender(patientsRequestDTO.getGender());
        entity.setDateOfBirth(patientsRequestDTO.getDateOfBirth());
        entity.setAllergies(patientsRequestDTO.getAllergies());
        entity.setCountry(patientsRequestDTO.getCountry());
        entity.setBloodType(patientsRequestDTO.getBloodType());
        entity.setMedicalHistory(patientsRequestDTO.getMedicalHistory());
        entity.setPicture(profileImageUrl);
    }

}
