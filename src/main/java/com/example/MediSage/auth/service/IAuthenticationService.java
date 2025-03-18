package com.example.MediSage.auth.service;


import com.example.MediSage.auth.dto.request.LoginRequestDTO;
import com.example.MediSage.auth.dto.response.LoginResponseDTO;

public interface IAuthenticationService {
    LoginResponseDTO login(LoginRequestDTO requestDTO );
}
