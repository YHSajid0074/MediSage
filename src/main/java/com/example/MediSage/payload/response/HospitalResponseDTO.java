package com.example.MediSage.payload.response;

import com.example.MediSage.generic.payload.response.BaseResponseDto;
import com.example.MediSage.payload.request.HospitalRequestDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class HospitalResponseDTO extends BaseResponseDto {

    private String name;

    private String email;

    private String phone;

    private String address;

    private String picture;

    private String city;

    private String state;

    private String country;

    private String zipCode;

    private List<String> specializations;

    private List<String> services;

    private Integer totalDoctors;

    private Integer establishedYear;
}
