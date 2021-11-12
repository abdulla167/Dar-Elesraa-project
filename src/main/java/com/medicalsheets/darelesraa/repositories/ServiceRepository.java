package com.medicalsheets.darelesraa.repositories;

import com.medicalsheets.darelesraa.entites.MedicalService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceRepository extends JpaRepository<MedicalService, Long> {
    Optional<MedicalService> findByName(String name);
}
