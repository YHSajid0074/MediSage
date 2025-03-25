package com.example.MediSage.payload.request;

import com.example.MediSage.generic.payload.request.IDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AiSummeryRequestDTO implements IDto {
    @NotBlank(message = "Summary text is required")
    private String summaryText;

    @NotNull(message = "Patient ID is required")
    private Long patientId;
}
