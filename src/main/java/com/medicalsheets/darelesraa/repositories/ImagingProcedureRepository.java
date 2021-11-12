package com.medicalsheets.darelesraa.repositories;

import com.medicalsheets.darelesraa.entites.ImagingProcedure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImagingProcedureRepository extends JpaRepository<ImagingProcedure, Long> {
    Optional<ImagingProcedure> findByName(String name);
}
