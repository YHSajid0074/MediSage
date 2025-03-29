package com.example.MediSage.service.impl;

import com.example.MediSage.auth.repository.UserRepo;
import com.example.MediSage.config.image.service.CloudneryImageService;
import com.example.MediSage.entity.doctor.Doctor;
import com.example.MediSage.generic.payload.response.PageData;
import com.example.MediSage.generic.repository.AbstractRepository;
import com.example.MediSage.generic.service.AbstractService;
import com.example.MediSage.payload.request.DoctorRequestDTO;
import com.example.MediSage.payload.request.DoctorSearchDTO;
import com.example.MediSage.payload.response.DoctorResponseDTO;
import com.example.MediSage.repository.doctor.DoctorRepository;
import com.example.MediSage.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Service
public class DoctorServiceIMPL extends AbstractService<Doctor, DoctorRequestDTO, DoctorSearchDTO> implements DoctorService {

    @Autowired
    CloudneryImageService cloudneryImageService;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    UserRepo userRepo;

    public DoctorServiceIMPL(AbstractRepository<Doctor> repository) {
        super(repository);
    }

    @Override
    protected DoctorResponseDTO convertToResponseDto(Doctor doctor) {
        DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO();
        doctorResponseDTO.setAchievements(doctor.getAchievements());
        doctorResponseDTO.setCertifications(doctor.getCertifications());
       doctorResponseDTO.setName(doctor.getName());
       doctorResponseDTO.setPhone(doctor.getPhone());
       doctorResponseDTO.setPicture(doctor.getPicture());
       doctorResponseDTO.setSpecialization(doctor.getSpecialization());
       doctorResponseDTO.setEmail(doctor.getEmail());
       doctorResponseDTO.setId(doctor.getId());
        return doctorResponseDTO;
    }

    @Override
    protected Doctor convertToEntity(DoctorRequestDTO doctorRequestDTO) throws IOException {
        return updateEntity(doctorRequestDTO, new Doctor());
    }

    @Override
    protected Doctor updateEntity(DoctorRequestDTO doctorRequestDTO, Doctor entity) throws IOException {
        entity.setAchievements(doctorRequestDTO.getAchievements());
        entity.setCertifications(doctorRequestDTO.getCertifications());
        entity.setName(doctorRequestDTO.getName());
        entity.setPhone(doctorRequestDTO.getPhone());
        entity.setSpecialization(doctorRequestDTO.getSpecialization());
        entity.setEmail(doctorRequestDTO.getEmail());
        entity.setUser(userRepo.findById(doctorRequestDTO.getUserId()).get());
        return entity;
    }

    @Override
    public void createV1(DoctorRequestDTO doctorRequestDTO, MultipartFile profilepic) throws IOException {

        Doctor entity=new Doctor();
        String   profileImageUrl = "https://res.cloudinary.com/dxmwiwy6g/image/upload/v1740298839/jhp0yhawmfwffy195dn8.jpg";

        if (profilepic != null) {
            Map<String, Object> heroUploadResult = cloudneryImageService.upload(profilepic);
            profileImageUrl = (String) heroUploadResult.get("secure_url");
        }

        entity.setUser(userRepo.findById(doctorRequestDTO.getUserId()).get());
        entity.setAchievements(doctorRequestDTO.getAchievements());
        entity.setCertifications(doctorRequestDTO.getCertifications());
        entity.setName(doctorRequestDTO.getName());
        entity.setPhone(doctorRequestDTO.getPhone());
        entity.setSpecialization(doctorRequestDTO.getSpecialization());
        entity.setEmail(doctorRequestDTO.getEmail());
        entity.setPicture(profileImageUrl);

        doctorRepository.save(entity);
    }

    @Override
    protected Specification<Doctor> buildSpecification(DoctorSearchDTO searchDto) {
        return null;
    }

    @Override
    public PageData search(DoctorSearchDTO searchDto, Pageable pageable) {
        Page<Doctor> doctors = doctorRepository.searchDoctors(
                Objects.nonNull(searchDto.getName()) && !searchDto.getName().trim().isBlank()
                        ? searchDto.getName() : null,
                Objects.nonNull(searchDto.getSpecialization()) && !searchDto.getSpecialization().trim().isBlank()
                        ? searchDto.getSpecialization() : null,
                searchDto.getIsActive(),
                pageable
        );

        return PageData.builder()
                .model(doctors.getContent().stream().map(this::convertToResponseDto).toList())
                .currentPage(doctors.getNumber() + 1)
                .totalPages(doctors.getTotalPages())
                .totalElements(doctors.getTotalElements())
                .build();
    }


}
