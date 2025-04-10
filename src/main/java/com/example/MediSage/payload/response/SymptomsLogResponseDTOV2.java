package com.example.MediSage.payload.response;

import com.example.MediSage.entity.patients.Patients;
import com.example.MediSage.entity.symptoms.entity.Symptoms;
import com.example.MediSage.generic.payload.response.BaseResponseDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SymptomsLogResponseDTOV2 extends BaseResponseDto {

    private LocalDateTime appointmentDate;
    private List<Symptoms> symptoms;
    private List<String> symptomsPart;

    public SymptomsLogResponseDTOV2(LocalDateTime appointmentDate, List<Symptoms> symptoms, List<String> symptomsPart) {
        this.appointmentDate = appointmentDate;
        this.symptoms = symptoms;
        this.symptomsPart = symptomsPart;
    }
}
