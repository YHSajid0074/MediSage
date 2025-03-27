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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patients patient;

    // Helper method for bidirectional synchronization
    public void setPatient(Patients patient) {
        if (this.patient != null) {
            this.patient.getAiSummaries().remove(this);
        }
        this.patient = patient;
        if (patient != null) {
            patient.getAiSummaries().add(this);
        }
    }
}
