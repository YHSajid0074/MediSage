package com.example.MediSage.entity.manualsymptomcheck.service;

import com.example.MediSage.entity.manualsymptomcheck.dto.request.ManualSymptomsCheckRequestDTO;
import com.example.MediSage.entity.manualsymptomcheck.entity.ManualSymptomsCheck;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.repository.AbstractRepository;
import com.example.MediSage.generic.service.IService;

public interface ManualSymptomsCheckService extends IService<ManualSymptomsCheck, ManualSymptomsCheckRequestDTO, GenericSearchDto> {
}
