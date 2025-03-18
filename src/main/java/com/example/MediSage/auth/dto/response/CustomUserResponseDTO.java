package com.example.MediSage.auth.dto.response;

import java.util.Set;

public interface CustomUserResponseDTO {

    Long getId();

    String getUsername();

    String getEmail();

    StudentInfo getStudent();

    interface StudentInfo {
        Long getId();
    }

    Set< RoleInfo > getRoles();

    interface RoleInfo {
        Long getId();

        String getRoleType();
    }
}
