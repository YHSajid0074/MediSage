package com.example.MediSage.repository.patients;

import com.example.MediSage.entity.patients.Patients;
import com.example.MediSage.generic.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepository extends AbstractRepository<Patients> {
}
