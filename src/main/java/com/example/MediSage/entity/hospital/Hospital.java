package com.example.MediSage.entity.hospital;

import com.example.MediSage.entity.doctor.Doctor;
import com.example.MediSage.generic.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "hospitals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hospital extends BaseEntity {

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "email", unique = true, length = 255)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    private String picture;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "state", length = 100)
    private String state;

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "zip_code", length = 20)
    private String zipCode;

    @ElementCollection
    @CollectionTable(name = "hospital_specializations", joinColumns = @JoinColumn(name = "hospital_id"))
    @Column(name = "specialization")
    private List<String> specializations;

    @ElementCollection
    @CollectionTable(name = "hospital_services", joinColumns = @JoinColumn(name = "hospital_id"))
    @Column(name = "service")
    private List<String> services;

    @Column(name = "total_doctors", columnDefinition = "INT DEFAULT 0")
    private Integer totalDoctors;

    @Column(name = "established_year")
    private Integer establishedYear;

    @ManyToMany(mappedBy = "hospitals")
    private Set<Doctor> doctors = new HashSet<>();

}

