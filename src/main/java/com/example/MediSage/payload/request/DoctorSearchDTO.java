package com.example.MediSage.payload.request;

import com.example.MediSage.generic.payload.request.SDto;
import lombok.Data;

@Data
public class DoctorSearchDTO extends SDto {
    private String name;
    private String specialization;
}
