package com.medicalsheets.darelesraa.services;

import com.medicalsheets.darelesraa.entites.Medicine;
import com.medicalsheets.darelesraa.repositories.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class MedicineServiceImpl implements MedicineService{
    private MedicineRepository medicineRepo;

    private EntityManager entityManager;

    @Autowired
    public MedicineServiceImpl(MedicineRepository medicineRepo) {
        this.medicineRepo = medicineRepo;
    }

    @Override
    public void addMedicine(Medicine medicine) {
        medicineRepo.save(medicine);
    }

    @Override
    public boolean updateMedicine(Medicine medicine, long medicineId) {
        boolean result = medicineRepo.existsById(medicineId);
        if (result == true){
            medicineRepo.save(medicine);
        }
        return result;
    }

    @Override
    public void deleteMedicine(long medicineId) {
        medicineRepo.deleteById(medicineId);
    }

    @Override
    public Optional<Medicine> getMedicineById(long medicineId) {
        Optional<Medicine> medicine = medicineRepo.findById(medicineId);;
        return medicine;
    }

    @Override
    public Optional<Medicine> getMedicineByName(String medicineName) {
        Optional<Medicine> medicine = medicineRepo.findByName(medicineName);;
        return medicine;
    }

    @Override
    public List<Medicine> getMedicines(){
        return medicineRepo.findAll();
    }

    List<Medicine> findAll() {
        Query query = this.entityManager.createQuery("SELECT m FROM Medicine m");
        List<Medicine> personsList = query.getResultList();
        return personsList;
    }
}
