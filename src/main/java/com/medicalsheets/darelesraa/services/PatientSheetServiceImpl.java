package com.medicalsheets.darelesraa.services;

import com.medicalsheets.darelesraa.entites.PatientSheet;
import com.medicalsheets.darelesraa.entites.Supply;
import com.medicalsheets.darelesraa.repositories.PatientSheetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientSheetServiceImpl implements PatientSheetService{
    private final PatientSheetRepository patientSheetRepository;

    public PatientSheetServiceImpl(PatientSheetRepository patientSheetRepository) {
        this.patientSheetRepository = patientSheetRepository;
    }

    @Override
    public void addPatientSheet(PatientSheet patientSheet) {
        this.patientSheetRepository.save(patientSheet);
    }

    @Override
    public boolean updatePatientSheet(PatientSheet patientSheet, long sheetId) {
        boolean result = this.patientSheetRepository.existsById(sheetId);
        if (result){
            this.patientSheetRepository.save(patientSheet);
        }
        return result;
    }

    @Override
    public void deletePatientSheet(long sheetId) {

    }

    @Override
    public Optional<PatientSheet> getPatientSheetById(long sheetId) {
        return this.patientSheetRepository.findById(sheetId);
    }

    @Override
    public Optional<PatientSheet> getPatientSheetByName(String patientFirstName, String patientMiddleName,
                                                        String patientLastName) {
        return this.patientSheetRepository.findByPatientName(patientFirstName, patientMiddleName, patientLastName);
    }

    @Override
    public List<PatientSheet> getPatientsSheets() {
        return this.patientSheetRepository.findAll();
    }
}
