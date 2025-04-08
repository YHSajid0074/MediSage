package com.example.MediSage.entity.symptoms.entity;

import com.example.MediSage.entity.appointment.Appointment;
import com.example.MediSage.generic.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Symptoms extends BaseEntity {

    public String name;

    @OneToMany(mappedBy = "symptoms")
    private List<Appointment> appointment;
}
