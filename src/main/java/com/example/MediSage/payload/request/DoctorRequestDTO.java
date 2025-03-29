package com.example.MediSage.payload.request;

import com.example.MediSage.generic.payload.request.IDto;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class DoctorRequestDTO implements IDto {
    @NotBlank(message = "Doctor name is required")
    @Size(max = 255, message = "Name cannot exceed 255 characters")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    @Size(max = 255, message = "Email cannot exceed 255 characters")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Size(max = 20, message = "Phone number cannot exceed 20 characters")
    private String phone;

    private MultipartFile picture;

    @NotBlank(message = "Specialization is required")
    @Size(max = 255, message = "Specialization cannot exceed 255 characters")
    private String specialization;

    private List<String> certifications;

    private List<String> achievements;

}
