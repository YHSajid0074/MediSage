package com.example.MediSage.service;

import com.example.MediSage.entity.patients.Patients;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.service.IService;
import com.example.MediSage.payload.request.PatientsRequestDTO;

public interface PatientsService extends IService<Patients, PatientsRequestDTO, GenericSearchDto> {
}
