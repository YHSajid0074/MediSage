package com.example.MediSage.entity.manualsymptomcheck.dto.response;

import com.example.MediSage.generic.payload.request.IDto;
import com.example.MediSage.generic.payload.response.BaseResponseDto;
import lombok.Data;

import java.util.List;

@Data
public class ManualSymptomsCheckResponseDTO extends BaseResponseDto{

    private Long id;

    private String currentMedication;

    private String pastCondition;

    private String symptomStartDate;

    private String painLevel;

    private String additionalNotes;

    private List<String> symptomsBother;

    private Long patientId;
}
