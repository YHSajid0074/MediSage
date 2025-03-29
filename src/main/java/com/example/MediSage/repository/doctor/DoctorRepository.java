package com.example.MediSage.repository.doctor;

import com.example.MediSage.entity.doctor.Doctor;
import com.example.MediSage.generic.repository.AbstractRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends AbstractRepository<Doctor> {

    @Query("""
    SELECT d FROM Doctor d
    WHERE (:name IS NULL OR LOWER(d.name) LIKE LOWER(CONCAT('%', :name, '%')))
    AND (:specialization IS NULL OR LOWER(d.specialization) LIKE LOWER(CONCAT('%', :specialization, '%')))
    AND d.isActive = :isActive
""")
    Page<Doctor> searchDoctors(
            @Param("name") String name,
            @Param("specialization") String specialization,
            @Param("isActive") Boolean isActive,
            Pageable pageable
    );
}
