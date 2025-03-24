package com.example.MediSage.repository.appointment;

import com.example.MediSage.entity.appointment.Appointment;
import com.example.MediSage.generic.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends AbstractRepository<Appointment> {
}
