package com.medicalsheets.darelesraa.services;

import com.medicalsheets.darelesraa.entites.PatientSheet;
import com.medicalsheets.darelesraa.entites.Supply;

import java.util.List;
import java.util.Optional;

public interface PatientSheetService {
    void addPatientSheet(PatientSheet patientSheet);

    boolean updatePatientSheet(PatientSheet patientSheet, long sheetId);

    void deletePatientSheet(long sheetId);

    Optional<PatientSheet> getPatientSheetById(long sheetId);

    Optional<PatientSheet> getPatientSheetByName(String patientFirstName, String patientMiddleName,
                                                 String patientLastName);
    List<PatientSheet> getPatientsSheets();
}
