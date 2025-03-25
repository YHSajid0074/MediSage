package com.example.MediSage.payload.request;

import com.example.MediSage.generic.payload.request.IDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class HospitalRequestDTO implements IDto {

    @NotBlank(message = "Hospital name is required")
    @Size(max = 255, message = "Name cannot exceed 255 characters")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    @Size(max = 255, message = "Email cannot exceed 255 characters")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Size(max = 20, message = "Phone number cannot exceed 20 characters")
    private String phone;

    @NotBlank(message = "Address is required")
    private String address;

    private MultipartFile picture;

    @NotBlank(message = "City is required")
    @Size(max = 100, message = "City name cannot exceed 100 characters")
    private String city;

    @NotBlank(message = "State is required")
    @Size(max = 100, message = "State name cannot exceed 100 characters")
    private String state;

    @NotBlank(message = "Country is required")
    @Size(max = 100, message = "Country name cannot exceed 100 characters")
    private String country;

    @NotBlank(message = "Zip code is required")
    @Size(max = 20, message = "Zip code cannot exceed 20 characters")
    private String zipCode;

    @NotNull(message = "Specializations cannot be null")
    private List<String> specializations;

    @NotNull(message = "Services cannot be null")
    private List<String> services;

    private Integer totalDoctors;

    private Integer establishedYear;

}
