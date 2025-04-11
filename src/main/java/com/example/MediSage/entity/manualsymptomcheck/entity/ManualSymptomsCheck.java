package com.example.MediSage.entity.manualsymptomcheck.entity;

import com.example.MediSage.generic.model.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class ManualSymptomsCheck extends BaseEntity {

    private String currentMedication;

    private String pastCondition;

    private String symptomStartDate;

    private String painLevel;

    private String additionalNotes;

}
