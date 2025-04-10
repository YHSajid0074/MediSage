package com.example.MediSage.payload.response;

import com.example.MediSage.entity.doctor.Doctor;
import com.example.MediSage.entity.patients.Patients;
import com.example.MediSage.entity.symptoms.entity.Symptoms;
import com.example.MediSage.generic.payload.response.BaseResponseDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SymptomsLogResponseDTO extends BaseResponseDto {

    private Patients patient;

    private LocalDateTime appointmentDate;

    List<Symptoms> symptoms;

    private List<String> SymptomsPart;
}
