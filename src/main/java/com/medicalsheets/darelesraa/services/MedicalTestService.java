package com.medicalsheets.darelesraa.services;

import com.medicalsheets.darelesraa.entites.MedicalTest;
import com.medicalsheets.darelesraa.entites.Medicine;

import java.util.List;
import java.util.Optional;

public interface MedicalTestService {
    void addMedicalTest(MedicalTest medicalTest);

    boolean updateMedicalTest(MedicalTest medicalTest, long medicalTestId);

    void deleteMedicalTest(long medicalTestId);

    Optional<MedicalTest> getMedicalTestById(long medicalTestId);

    Optional<MedicalTest> getMedicalTestByName(String medicalTestName);

    List<MedicalTest> getMedicalTests();
}
