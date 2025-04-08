package com.example.MediSage.entity.symptoms.repository;

import com.example.MediSage.entity.symptoms.entity.Symptoms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SymptomsRepository extends JpaRepository<Symptoms, Long> {

    @Query("SELECT s FROM Symptoms s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Symptoms> findByNameIgnoreCase(@Param("name") String name);
}
