package com.example.MediSage.auth.dto.response;

import java.time.LocalDate;
import java.util.Set;

public interface CustomUserResponseDTO {

    Long getId();

    String getUsername();

    String getEmail();

    Set< RoleInfo > getRoles();

    interface RoleInfo {
        Long getId();

        String getRoleType();
    }

    PatientsInfo getPatient();
    interface PatientsInfo {
        Long getId();
        String getFullName();
        String getHealthGoals();
         LocalDate getDateOfBirth();
      String getGender();
         Long getWeight();
       Long getHeight();
         String getEatingHabit();
         String getMedications();
      String getMedicalConditions();
     String getBloodType();
     String getHealthNotes();
    }
}
