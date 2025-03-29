package com.example.MediSage.service;

import com.example.MediSage.entity.doctor.Doctor;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.service.IService;
import com.example.MediSage.payload.request.DoctorRequestDTO;
import com.example.MediSage.payload.request.DoctorSearchDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface DoctorService extends IService<Doctor, DoctorRequestDTO, DoctorSearchDTO> {
    public void createV1(DoctorRequestDTO doctorRequestDTO,  MultipartFile profilepic) throws IOException;

}
