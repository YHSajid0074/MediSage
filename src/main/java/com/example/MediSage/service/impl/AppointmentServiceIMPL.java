package com.example.MediSage.service.impl;

import com.example.MediSage.entity.appointment.Appointment;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.payload.response.BaseResponseDto;
import com.example.MediSage.generic.repository.AbstractRepository;
import com.example.MediSage.generic.service.AbstractService;
import com.example.MediSage.payload.request.AppointmentRequestDTO;
import com.example.MediSage.payload.response.AppointmentResponseDTO;
import com.example.MediSage.repository.doctor.DoctorRepository;
import com.example.MediSage.repository.hospital.HospitalRepository;
import com.example.MediSage.repository.patients.PatientsRepository;
import com.example.MediSage.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AppointmentServiceIMPL extends AbstractService<Appointment, AppointmentRequestDTO, GenericSearchDto> implements AppointmentService {

    @Autowired
    PatientsRepository patientsRepository;

  @Autowired

  HospitalRepository hospitalRepository;

  @Autowired
  DoctorRepository doctorRepository;

    public AppointmentServiceIMPL(AbstractRepository<Appointment> repository) {
        super(repository);
    }

    @Override
    protected AppointmentResponseDTO convertToResponseDto(Appointment appointment) {

        AppointmentResponseDTO appointmentResponseDTO = new AppointmentResponseDTO();

        appointmentResponseDTO.setAppointmentDate(appointment.getAppointmentDate());
        appointmentResponseDTO.setStatus(appointment.getStatus());
        appointmentResponseDTO.setAiSummary(appointment.getAiSummary());
        appointmentResponseDTO.setNotes(appointment.getNotes());
        appointmentResponseDTO.setPatient(appointment.getPatient());
        appointmentResponseDTO.setDoctor(appointment.getDoctor());
        appointmentResponseDTO.setPrescription(appointment.getPrescription());

        return appointmentResponseDTO;
    }

    @Override
    protected Appointment convertToEntity(AppointmentRequestDTO appointmentRequestDTO) throws IOException {
        return updateEntity(appointmentRequestDTO, new Appointment());
    }

    @Override
    protected Appointment updateEntity(AppointmentRequestDTO appointmentRequestDTO, Appointment entity) throws IOException {

        entity.setAppointmentDate(appointmentRequestDTO.getAppointmentDate());
        entity.setStatus(appointmentRequestDTO.getStatus());
        entity.setAiSummary(appointmentRequestDTO.getAiSummary());
        entity.setNotes(appointmentRequestDTO.getNotes());
        entity.setPrescription(appointmentRequestDTO.getPrescription());
        entity.setDoctor(doctorRepository.findById(appointmentRequestDTO.getDoctorId()).get());
        entity.setPatient(patientsRepository.findById(appointmentRequestDTO.getPatientId()).get());

        return entity;
    }

    @Override
    protected Specification<Appointment> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
