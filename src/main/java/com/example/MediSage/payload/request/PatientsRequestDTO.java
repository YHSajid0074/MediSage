package com.example.MediSage.payload.request;

import com.example.MediSage.generic.payload.request.IDto;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PatientsRequestDTO implements IDto {
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

    private long userId;


}
