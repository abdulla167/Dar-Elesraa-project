package com.medicalsheets.darelesraa.repositories;

import com.medicalsheets.darelesraa.entites.PatientSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface PatientSheetRepository extends JpaRepository<PatientSheet, Long> {
    @Query("Select m FROM PatientSheet m WHERE m.patientFirstName LIKE :firstName% " +
            "AND m.patientMiddleName LIKE :middleName% AND m.patientLastName LIKE :lastName%")
    Optional<PatientSheet> findByPatientName(@Param("firstName") String firstName,
                                             @Param("middleName") String middleName,
                                             @Param("lastName") String lastName);
}
