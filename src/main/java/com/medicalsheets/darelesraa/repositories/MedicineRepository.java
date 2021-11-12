package com.medicalsheets.darelesraa.repositories;

import com.medicalsheets.darelesraa.entites.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    Optional<Medicine> findByName(String medicineName);
}
