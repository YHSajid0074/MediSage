package com.example.MediSage.auth.dto.request;
import java.io.Serializable;

public record RoleRequestDTO(

        String roleType

)
        implements Serializable {
}
