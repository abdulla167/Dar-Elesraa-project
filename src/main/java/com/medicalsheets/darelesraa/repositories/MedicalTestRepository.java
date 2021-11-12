package com.medicalsheets.darelesraa.repositories;

import com.medicalsheets.darelesraa.entites.MedicalTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicalTestRepository extends JpaRepository<MedicalTest, Long> {
    Optional<MedicalTest> findByName(String name);
}
