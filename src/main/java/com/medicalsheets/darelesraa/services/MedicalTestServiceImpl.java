package com.medicalsheets.darelesraa.services;

import com.medicalsheets.darelesraa.entites.MedicalTest;
import com.medicalsheets.darelesraa.entites.Medicine;
import com.medicalsheets.darelesraa.repositories.MedicalTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalTestServiceImpl implements MedicalTestService{
    private final MedicalTestRepository medicalTestRepository;

    @Autowired
    public MedicalTestServiceImpl(MedicalTestRepository medicalTestRepository) {
        this.medicalTestRepository = medicalTestRepository;
    }

    @Override
    public void addMedicalTest(MedicalTest medicalTest) {
        this.medicalTestRepository.save(medicalTest);
    }

    @Override
    public boolean updateMedicalTest(MedicalTest medicalTest, long medicalTestId) {
        boolean result = this.medicalTestRepository.existsById(medicalTestId);
        if (result){
            this.medicalTestRepository.save(medicalTest);
        }
        return result;
    }

    @Override
    public void deleteMedicalTest(long medicalTestId) {
        this.medicalTestRepository.deleteById(medicalTestId);
    }

    @Override
    public Optional<MedicalTest> getMedicalTestById(long medicalTestId) {
        return this.medicalTestRepository.findById(medicalTestId);
    }

    @Override
    public Optional<MedicalTest> getMedicalTestByName(String medicalTestName) {
        return this.medicalTestRepository.findByName(medicalTestName);
    }

    @Override
    public List<MedicalTest> getMedicalTests() {
        return this.medicalTestRepository.findAll();
    }
}
