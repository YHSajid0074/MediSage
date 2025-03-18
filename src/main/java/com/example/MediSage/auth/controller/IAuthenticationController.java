package com.example.MediSage.auth.controller;

import com.example.MediSage.auth.dto.request.LoginRequestDTO;
import com.example.MediSage.auth.dto.response.LoginResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IAuthenticationController {

    ResponseEntity<LoginResponseDTO> login(LoginRequestDTO requestDTO );

}
