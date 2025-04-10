package com.example.MediSage.entity.symptomlog;

import com.example.MediSage.entity.doctor.Doctor;
import com.example.MediSage.entity.patients.Patients;
import com.example.MediSage.entity.symptoms.entity.Symptoms;
import com.example.MediSage.generic.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "symptomsLog")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SymptomLogs extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonIgnore
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

    @ManyToMany
    @JoinTable(
            name = "appointment_symptoms",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "symptom_id")
    )
    private List<Symptoms> symptoms=new ArrayList<>();

    @ElementCollection
    private List<String>SymptomsPart;


//    // Helper methods for bidirectional synchronization
//    public void setDoctor(Doctor doctor) {
//        if (this.doctor != null) {
//            this.doctor.setSymptomLogs(null);
//        }
//        this.doctor = doctor;
//        if (doctor != null) {
//            doctor.setSymptomLogs(this);
//        }
//    }
//
//    public void setPatient(Patients patient) {
//        if (this.patient != null) {
//            this.patient.setSymptomLogs(null);
//        }
//        this.patient = patient;
//        if (patient != null) {
//            patient.setSymptomLogs(this);
//        }
//    }
}