package com.example.MediSage.entity.appointment;

import com.example.MediSage.entity.doctor.Doctor;
import com.example.MediSage.entity.patients.Patients;
import com.example.MediSage.generic.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "doctor_id", unique = true)
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name = "patient_id",unique = true)
    private Patients patient;

    @Column(name = "appointment_date")
    private LocalDateTime appointmentDate;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "ai_summary", columnDefinition = "TEXT")
    private String aiSummary;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name = "prescription")
    private String prescription;
}
