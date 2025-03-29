package com.example.MediSage.controller;

import com.example.MediSage.entity.appointment.Appointment;
import com.example.MediSage.generic.controller.AbstractController;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.service.IService;
import com.example.MediSage.payload.request.AppointmentRequestDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("Appointment")
@RestController
public class AppointmentController extends AbstractController<Appointment, AppointmentRequestDTO, GenericSearchDto> {
    public AppointmentController(IService<Appointment, AppointmentRequestDTO, GenericSearchDto> service) {
        super(service);
    }
}
