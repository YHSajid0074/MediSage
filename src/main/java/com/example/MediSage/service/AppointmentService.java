package com.example.MediSage.service;

import com.example.MediSage.entity.appointment.Appointment;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.service.IService;
import com.example.MediSage.payload.request.AppointmentRequestDTO;

public interface AppointmentService extends IService<Appointment, AppointmentRequestDTO,GenericSearchDto> {
}
