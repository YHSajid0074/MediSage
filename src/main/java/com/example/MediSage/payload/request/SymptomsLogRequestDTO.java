package com.example.MediSage.payload.request;

import com.example.MediSage.generic.payload.request.IDto;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SymptomsLogRequestDTO implements IDto {


    @NotNull(message = "Patient ID is required")
    private Long patientId;

    private List<Long> symptomIds;

    private List<String>SymptomsPart;


}
