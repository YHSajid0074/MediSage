package com.example.MediSage.repository.appointment;

import com.example.MediSage.entity.symptomlog.SymptomLogs;
import com.example.MediSage.generic.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomsLogRepository extends AbstractRepository<SymptomLogs> {
}
