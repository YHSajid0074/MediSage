package com.example.MediSage.entity.doctor;

import com.example.MediSage.entity.appointment.Appointment;
import com.example.MediSage.entity.hospital.Hospital;
import com.example.MediSage.generic.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctors")
public class Doctor extends BaseEntity {

    private String name;

    @Column(unique = true)
    private String email;

    private String phone;

    private String picture;

    private String specialization;

    @ElementCollection
    @CollectionTable(name = "doctor_certifications", joinColumns = @JoinColumn(name = "doctor_id"))
    @Column(name = "certification")
    private List<String> certifications;

    @ElementCollection
    @CollectionTable(name = "doctor_achievements", joinColumns = @JoinColumn(name = "doctor_id"))
    @Column(name = "achievement")
    private List<String> achievements;

    @ManyToMany(mappedBy = "doctors", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Hospital> hospitals = new HashSet<>();

    @OneToOne(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Appointment appointment;
}
