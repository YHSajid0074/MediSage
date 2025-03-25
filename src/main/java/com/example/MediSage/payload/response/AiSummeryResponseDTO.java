package com.example.MediSage.payload.response;

import com.example.MediSage.entity.patients.Patients;
import com.example.MediSage.generic.model.BaseEntity;
import com.example.MediSage.generic.payload.response.BaseResponseDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AiSummeryResponseDTO extends BaseResponseDto{

    private String summaryText;

    private Patients patient;
}
