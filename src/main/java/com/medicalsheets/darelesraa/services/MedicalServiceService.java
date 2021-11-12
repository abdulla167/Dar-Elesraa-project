package com.medicalsheets.darelesraa.services;

import com.medicalsheets.darelesraa.entites.MedicalService;
import com.medicalsheets.darelesraa.entites.Medicine;

import java.util.List;
import java.util.Optional;

public interface MedicalServiceService {
    void addService(MedicalService medicalService);

    boolean updateService(MedicalService medicalService, long serviceId);

    void deleteService(long serviceId);

    Optional<MedicalService> getServiceById(long serviceId);

    public Optional<MedicalService> getServiceByName(String serviceName);

    public List<MedicalService> getServices();

}
