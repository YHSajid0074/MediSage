package com.example.MediSage.entity.aisummary;

import com.example.MediSage.entity.patients.Patients;
import com.example.MediSage.generic.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ai_summaries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AiSummary extends BaseEntity {

    @Column(name = "summary_text", columnDefinition = "TEXT")
    private String summaryText;

    @OneToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id", unique = true)
    private Patients patient;
}

