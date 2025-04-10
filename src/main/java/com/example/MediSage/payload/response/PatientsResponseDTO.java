package com.example.MediSage.payload.response;

import com.example.MediSage.entity.symptoms.entity.Symptoms;
import com.example.MediSage.generic.payload.response.BaseResponseDto;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PatientsResponseDTO extends BaseResponseDto {

    private String fullName;
    private String healthGoals;
    private LocalDate dateOfBirth;
    private String gender;
    private Long weight;
    private Long height;
    private String eatingHabit;
    private String medications;
    private String medicalConditions;
    private String bloodType;
    private String healthNotes;

    private List<SymptomsLogResponseDTOV2> symptomLogs;


}