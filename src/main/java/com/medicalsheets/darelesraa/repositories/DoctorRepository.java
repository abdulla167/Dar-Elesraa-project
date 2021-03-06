package com.medicalsheets.darelesraa.repositories;

import com.medicalsheets.darelesraa.entites.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByName(String name);
}
