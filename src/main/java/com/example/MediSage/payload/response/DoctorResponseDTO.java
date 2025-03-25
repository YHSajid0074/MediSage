package com.example.MediSage.payload.response;

import com.example.MediSage.generic.payload.response.BaseResponseDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class DoctorResponseDTO extends BaseResponseDto {

    private String name;

    private String email;

    private String phone;

    private String picture;

    private String specialization;

    private List<String> certifications;

    private List<String> achievements;
}
