package com.medicalsheets.darelesraa.services;

import com.medicalsheets.darelesraa.entites.Medicine;

import java.util.List;
import java.util.Optional;

public interface MedicineService {

    void addMedicine(Medicine medicine);

    boolean updateMedicine(Medicine medicine, long medicineId);

    void deleteMedicine(long medicineId);

    Optional<Medicine> getMedicineById(long medicineId);

    Optional<Medicine> getMedicineByName(String medicineName);

    List<Medicine> getMedicines();
}
