package com.example.MediSage.entity.symptoms.entity;

import com.example.MediSage.generic.model.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Symptoms extends BaseEntity {
    public String name;
}
