package com.example.MediSage.entity.patients;

import com.example.MediSage.auth.model.User;
import com.example.MediSage.entity.aisummary.AiSummary;
import com.example.MediSage.entity.appointment.Appointment;
import com.example.MediSage.generic.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patients extends BaseEntity {

    @Column(name = "fullname", length = 100)
    private String fullName;

    private String healthGoals;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "gender", length = 10)
    private String gender;

    private Long weight;

    private Long height;

    private String eatingHabit;

    private String medications;

    private String medicalConditions;

    @Column(name = "blood_type", length = 5)
    private String bloodType;

    private String healthNotes;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Appointment appointment;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AiSummary> aiSummaries = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;
}
