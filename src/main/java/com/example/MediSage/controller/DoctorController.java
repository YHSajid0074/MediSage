package com.example.MediSage.controller;

import com.example.MediSage.entity.doctor.Doctor;
import com.example.MediSage.generic.controller.AbstractController;
import com.example.MediSage.generic.payload.request.GenericSearchDto;
import com.example.MediSage.generic.service.IService;
import com.example.MediSage.payload.request.DoctorRequestDTO;
import com.example.MediSage.payload.request.DoctorSearchDTO;
import com.example.MediSage.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("Doctor")
public class DoctorController extends AbstractController<Doctor, DoctorRequestDTO, DoctorSearchDTO> {

    @Autowired
    DoctorService doctorService;
    public DoctorController(IService<Doctor, DoctorRequestDTO, DoctorSearchDTO> service) {
        super(service);
    }

    @PostMapping(value = "/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String>createv1(@ModelAttribute DoctorRequestDTO doctorRequestDTO) throws IOException {
        MultipartFile profilpic = doctorRequestDTO.getPicture();
        doctorService.createV1(doctorRequestDTO,profilpic);
        return new ResponseEntity<>("Doctor created successfully", HttpStatus.CREATED);
    }
}
