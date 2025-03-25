package com.example.MediSage.payload.response;

import com.example.MediSage.generic.payload.response.BaseResponseDto;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PatientsResponseDTO extends BaseResponseDto {

    private String firstName;

    private String lastName;

    private String email;

    private String picture;

    private String phone;

    private LocalDate dateOfBirth;

    private String gender;

    private String address;

    private String city;

    private String state;

    private String country;

    private String zipCode;

    private List<String> medicalHistory;

    private List<String> allergies;

    private String bloodType;
}
