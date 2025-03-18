package com.example.MediSage.auth.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record UserRoleRequestDTO(

        @NotNull( message = "User id can't be null or empty." )
        Long userId,

        @NotNull( message = "Role ids can't be null or empty." )
        Set< Long > roleIds
) {
}
