package com.example.MediSage.auth.controller;

import com.example.MediSage.auth.dto.request.LoginRequestDTO;
import com.example.MediSage.auth.dto.response.LoginResponseDTO;
import com.example.MediSage.auth.service.IAuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Log")
public class AuthenticationController implements IAuthenticationController {


    private IAuthenticationService authenticationService;
    public AuthenticationController(IAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping()
    @Override
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO requestDTO ) {
        return ResponseEntity.ok( authenticationService.login( requestDTO ) );
    }
}
