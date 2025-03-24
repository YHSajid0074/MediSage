package com.example.MediSage.service;

import com.example.MediSage.entity.hospital.Hospital;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.service.IService;
import com.example.MediSage.payload.request.HospitalRequestDTO;

public interface HospitalService extends IService<Hospital, HospitalRequestDTO, GenericSearchDto> {
}
