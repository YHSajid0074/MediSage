package com.example.MediSage.service;

import com.example.MediSage.entity.doctor.Doctor;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.service.IService;
import com.example.MediSage.payload.request.DoctorRequestDTO;


public interface DoctorService extends IService<Doctor, DoctorRequestDTO, GenericSearchDto> {
}
