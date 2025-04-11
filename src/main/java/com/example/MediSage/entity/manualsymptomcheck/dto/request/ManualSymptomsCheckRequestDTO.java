package com.example.MediSage.entity.manualsymptomcheck.dto.request;

import com.example.MediSage.generic.payload.request.IDto;
import lombok.Data;

import java.util.List;

@Data
public class ManualSymptomsCheckRequestDTO implements IDto {

    private String currentMedication;

    private String pastCondition;

    private String symptomStartDate;

    private String painLevel;

    private String additionalNotes;

    private List<String> symptomsBother;
}
