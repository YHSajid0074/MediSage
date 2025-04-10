package com.example.MediSage.entity.symptoms.entity;

import com.example.MediSage.entity.symptomlog.SymptomLogs;
import com.example.MediSage.generic.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany(mappedBy = "symptoms")
    private List<SymptomLogs> symptomLogs;
}
