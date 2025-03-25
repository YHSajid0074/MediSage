package com.example.MediSage.payload.response;

import com.example.MediSage.entity.doctor.Doctor;
import com.example.MediSage.entity.patients.Patients;
import com.example.MediSage.generic.payload.response.BaseResponseDto;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentResponseDTO extends BaseResponseDto {

    private Doctor doctor;

    private Patients patient;

    private LocalDateTime appointmentDate;

    private String status;

    private String aiSummary;

    private String notes;

    private String prescription;
}
