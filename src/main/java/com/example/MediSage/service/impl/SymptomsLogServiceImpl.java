package com.example.MediSage.service.impl;

import com.example.MediSage.entity.symptomlog.SymptomLogs;
import com.example.MediSage.entity.doctor.Doctor;
import com.example.MediSage.entity.patients.Patients;
import com.example.MediSage.entity.symptoms.entity.Symptoms;
import com.example.MediSage.entity.symptoms.repository.SymptomsRepository;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.repository.AbstractRepository;
import com.example.MediSage.generic.service.AbstractService;
import com.example.MediSage.payload.request.SymptomsLogRequestDTO;
import com.example.MediSage.payload.response.SymptomsLogResponseDTO;
import com.example.MediSage.repository.doctor.DoctorRepository;
import com.example.MediSage.repository.hospital.HospitalRepository;
import com.example.MediSage.repository.patients.PatientsRepository;
import com.example.MediSage.service.SymptomsLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class SymptomsLogServiceImpl extends AbstractService<SymptomLogs, SymptomsLogRequestDTO, GenericSearchDto> implements SymptomsLogService {

    @Autowired
    PatientsRepository patientsRepository;

  @Autowired

  HospitalRepository hospitalRepository;

  @Autowired
  DoctorRepository doctorRepository;

  @Autowired
  SymptomsRepository symptomsRepository;

    public SymptomsLogServiceImpl(AbstractRepository<SymptomLogs> repository) {
        super(repository);
    }

    @Override
    protected SymptomsLogResponseDTO convertToResponseDto(SymptomLogs symptomLogs) {

        SymptomsLogResponseDTO symptomsLogResponseDTO = new SymptomsLogResponseDTO();

        symptomsLogResponseDTO.setAppointmentDate(symptomLogs.getAppointmentDate());
        symptomsLogResponseDTO.setSymptomsPart(symptomLogs.getSymptomsPart());
        symptomsLogResponseDTO.setSymptoms(symptomLogs.getSymptoms());


        return symptomsLogResponseDTO;
    }

    @Override
    protected SymptomLogs convertToEntity(SymptomsLogRequestDTO symptomsLogRequestDTO) throws IOException {
        return updateEntity(symptomsLogRequestDTO, new SymptomLogs());
    }

    @Override
    protected SymptomLogs updateEntity(SymptomsLogRequestDTO symptomsLogRequestDTO, SymptomLogs entity) throws IOException {

//        entity.setAppointmentDate(symptomsLogRequestDTO.getAppointmentDate());


        Patients patient = patientsRepository.findById(symptomsLogRequestDTO.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("Patient not found with ID: " + symptomsLogRequestDTO.getPatientId()));
        entity.setPatient(patient);

        if (symptomsLogRequestDTO.getSymptomIds() != null && !symptomsLogRequestDTO.getSymptomIds().isEmpty()) {
            List<Symptoms> symptoms = symptomsRepository.findAllById(symptomsLogRequestDTO.getSymptomIds());
            entity.setSymptoms(symptoms);
        } else {
            entity.setSymptoms(Collections.emptyList()); // বা null রাখো যদি সেটাই দরকার হয়
        }

        entity.setSymptomsPart(symptomsLogRequestDTO.getSymptomsPart());

        return entity;
    }


    @Override
    protected Specification<SymptomLogs> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
